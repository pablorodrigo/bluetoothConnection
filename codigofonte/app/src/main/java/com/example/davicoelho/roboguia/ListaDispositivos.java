package com.example.davicoelho.roboguia;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class ListaDispositivos extends AppCompatActivity {


	/*Objeto referente ao radio bluetooth do dispisitivo*/
    private BluetoothAdapter adaptador;

    /*Objeto referente a ListView*/
    private ListView lista;

    /*Objeto responsavel por retornar dados de um dispositivo exteno e adiciona-lo ao ListView*/
    private ArrayAdapter<String> dispositivos;

    /*Objeto referente a Widget Button Pesquisar*/
    private Button btPesquisar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dispositivos);

		/*Confirando o objeto principal para a comunica��o bluetooth */
        adaptador = BluetoothAdapter.getDefaultAdapter();

		/*Apontando o objeto Button ao bot�o Pesquisar do xml*/
        btPesquisar = (Button) findViewById(R.id.btPesquisar);
		/*Configurando o evento do bot�o Pesquisar*/
        btPesquisar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
				/*Chamando o m�todo pesquisar*/
                pesquisar();
            }
        });

		/*Apontando o objeto ListView a lista de dispositivos extenos xml*/
        lista = (ListView) findViewById(R.id.lvDispositivos);

		/*Inicializando a vari�vel ArrayAdapter e seu tipo de texto*/
        dispositivos = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1);

		/*Adicionando a ArrayAdapter a widget ListView*/
        lista.setAdapter(dispositivos);
		/*Configurando o evento de clique na ListView*/
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long id) {
				/*Vari�veis respons�veis por retornar o endere�o do item da lista selecionado*/
                String info = ((TextView) view).getText().toString();
                String address = info.substring(info.length() - 17);

				/*Instanciando um objeto intent*/
                Intent it = new Intent();

				/*Configurando os dados que ser�o retornados para a primeira tela (Activity)
				 * o primeiro par�metro � um id de identifica��o e o segundo s�o os dados que
				 * ser�o retornados para a primeira tela*/
                it.putExtra("msg", address);

				/*Metodo que envia os dados para a outra tela*/
                setResult(Activity.RESULT_OK, it);

				/*Metodo nativo do Android que finaliza esta tela*/
                finish();
            }
        });

		/*Configuracao padrao para retornar dados dos dispositivos encontrados
		 * e adiciona-los ao ListView*/
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, filter);

        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);

        Set<BluetoothDevice> pairedDevices = adaptador.getBondedDevices();

        if (pairedDevices.size() > 0) {

            for (BluetoothDevice device : pairedDevices) {

                dispositivos.add(device.getName() + "\n"+ device.getAddress());
            }

        }

    }

    /*Metodo responsavel pela pesquisa por dispositivos externos*/
    private void pesquisar() {

        alerta("Pesquisando ... ");

        if (adaptador.isDiscovering()) {
			/*Cancela a conex�o se caso o aparelho estiver fazendo uma pesquisa*/
            adaptador.cancelDiscovery();
        }

		/*Come�a a fazer uma pesquisa por dispositivos externos*/
        adaptador.startDiscovery();

		/*limpa os dispositivos da ListView*/
        dispositivos.clear();
    }

    /*Metodo nativo do Android sobrescrito para evitar erros*/
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (adaptador != null) {
            adaptador.cancelDiscovery();
        }

        this.unregisterReceiver(mReceiver);
    }

    /*Metodo responsavel por utilizar o hardware do celular para retornar os dispositivos encontrados*/
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {

                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                dispositivos.add(device.getName() + "\n"+ device.getAddress());
            }
        }
    };



    /*M�todos respons�veis para o envio de uma mensagem na tela*/
    private final Handler h = new Handler() {
        public void handleMessage(Message msg) {
            String content = (String) msg.obj;
            Toast.makeText(ListaDispositivos.this, content, Toast.LENGTH_SHORT).show();
        }
    };

    public void alerta(String message) {
        Message m = h.obtainMessage();
        m.obj = message;
        h.sendMessage(m);
    }
}
