package com.example.davicoelho.roboguia;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.media.SoundPool;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davicoelho.lejos.nxt.ColorSensor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ColorSensor colorSensor;

    private BluetoothAdapter adaptador;

    private BluetoothDevice device;

    /*Objeto referente ao socket da conexao*/
    private BluetoothSocket socket;

    /*Objeto referente ao fluxo de saida de dados*/
    private DataOutputStream output;

    private Button btConectar;

    private TextView textColor;

    /*Objeto referente a uma Intent*/
    private Intent it;

    /*Vari�vel respons�vel por armazenar o n�mero de identifica��o da tela */
    private static final int ListaDispositivos = 1;

    /*String que receber� o endere�o MAC do dispositivo escolhido na widget ListView*/
    private String address;

    /*Objeto do tipo ConnectThread*/
    private ConnectThread teste;

    /*Vari�vel auxiliar para os eventos dos bot�es*/
    private boolean pressedUp = false;

    private SoundPool sound;

    private int soundFrente;
    private int soundEsquerda;
    private int soundDireita;
    private int soundPare;
    private int soundLonge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sound = new SoundPool(5, AudioManager.STREAM_MUSIC, 100);

        soundFrente = sound.load(this, R.raw.frente, 1);
        soundEsquerda = sound.load(this, R.raw.esquerda, 1);
        soundDireita = sound.load(this, R.raw.direita, 1);
        soundPare = sound.load(this, R.raw.pare, 1);
        soundLonge = sound.load(this, R.raw.longe, 1);



        /*Adicionando null a vari�vel device*/
        device = null;

		/*Adicionando null a vari�vel address*/
        address = null;

        btConectar = (Button) findViewById(R.id.btConectar);

		/*Adicionando um evento ao Button Conectar*/
        btConectar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
				/*Chamando a tela 2*/
                startActivityForResult(it, ListaDispositivos);

            }
        });



		/*Confirando o objeto principal para a comunica��o bluetooth */
        adaptador = BluetoothAdapter.getDefaultAdapter();

		/*Estrutura de decis�o para ligar o Bluetooth*/
        if (!adaptador.isEnabled()) {

			/*Se o R�dio Bluetooth estiver desligado BluetoothAdapter
			  solicitar� a permiss�o do usu�rio para ligar o Bluetooth*/
            Intent enableBtIntent = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }

    }




    /* public void receiveMessage(View view) {
        while(true) {
            int numId = this.connector.readMessage();
            if (numId != 0) {
                playSound(numId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //this.connector.writeMessage();
            }
        }
    }*/


    protected void playSound(int soundID ) {
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float leftVolume = curVolume / maxVolume;
        float rightVolume = curVolume / maxVolume;
        int priority = 1;
        int no_loop = 0;
        float normal_playback_rate = 1f;
        sound.play(soundID, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
    }

    /*Metodo de conexao com um dispositivo externo*/
    private class ConnectThread extends Thread {

        /*Variavel final que armazenara o dispositivo escolhido para a conexão*/
        private final BluetoothDevice mmDevice;

        /*Construtor do ConnectThread*/
        public ConnectThread(BluetoothDevice device) {
            mmDevice = device;
            BluetoothSocket tmp = null;

            try {

				/*Vari�vel socket recebe um identificador �nico UUID*/
                tmp = device.createRfcommSocketToServiceRecord(UUID
                        .fromString("00001101-0000-1000-8000-00805F9B34FB"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            socket = tmp;
        }

        public void run() {
			/*Cancela a pesquisa de dispositivos externos para economizar banda*/
            adaptador.cancelDiscovery();

            try {
				/*Socket conecta a aplicativo Android no dispositivo externo*/
                socket.connect();
                alerta("Conexão Aberta");
            } catch (IOException e) {
                try {
                    socket.close();
                    alerta("Erro de Conexão");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return;
            }

        }


}

    public void cancel() {
        try {
            socket.close();
            alerta("Conexão Fechada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*Metodo de retorno de dados da Tela 2*/
    protected void onActivityResult(int codigo, int resultado, Intent it) {
        if (it == null) {
            alerta("Nenhum Endereço Selecionado");
            return;
        }

		/*Vari�vel String que vai retornar o endere�o MAC do dispositivo selecionado*/
        address = it.getExtras().getString("msg");
        alerta("Novo endereço " + address);

		/*Configurando o BluetoothDevice device com o MAC selecionado*/
        device = adaptador.getRemoteDevice(address);

		/*Metodo ConnectThead recebe o argumento device*/
        teste = new ConnectThread(device);

		/*A variavel texte e executada*/
        teste.start();
    }

/*M�todos respons�veis para o envio de uma mensagem na tela*/
private final Handler h = new Handler() {
    public void handleMessage(Message msg) {
        String content = (String) msg.obj;
        Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT)
                .show();
    }
};

    public void alerta(String message) {
        Message m = h.obtainMessage();
        m.obj = message;
        h.sendMessage(m);
    }

}
