package com.example.davicoelho.lejos.nxt;

import icommand.nxt.comm.NXTProtocol;

// TODO: Auto-generated Javadoc

/**
 * MTRMX-Nx by Mindsensors.com is a motor multiplexer for RCX motors.
 * 
 * RCXMotorMultiplexer expansion = new RCXMotorMultiplexer(Port.S1); expansion.A.forward();
 * 
 * @author BB
 */
public class RCXMotorMultiplexer extends I2CSensor {

  /** The A. */
  public RCXMotorMultiplexer.Motor A = new Motor(0);

  /** The B. */
  public RCXMotorMultiplexer.Motor B = new Motor(1);

  /** The C. */
  public RCXMotorMultiplexer.Motor C = new Motor(2);

  /** The D. */
  public RCXMotorMultiplexer.Motor D = new Motor(2);

  /** The Constant COMMAND. */
  private final static byte COMMAND = 0x41;
  
  /** The Constant MOTOR_A_DIR. */
  private final static byte MOTOR_A_DIR = 0x42;
  
  /** The Constant MOTOR_A_SPEED. */
  private final static byte MOTOR_A_SPEED = 0x43;
  /*
   * Unused constants because each Motor object calculates based on Motor.port private final static
   * byte MOTOR_B_DIR = 0x44; private final static byte MOTOR_B_SPEED = 0x45; private final static
   * byte MOTOR_C_DIR = 0x46; private final static byte MOTOR_C_SPEED = 0x47; private final static
   * byte MOTOR_D_DIR = 0x48; private final static byte MOTOR_D_SPEED = 0x49;
   */
  /** The Constant FLT. */
  private final static byte FLT = 0x00;
  
  /** The Constant FORWARD. */
  private final static byte FORWARD = 0x01;
  
  /** The Constant BACKWARD. */
  private final static byte BACKWARD = 0x02;
  
  /** The Constant BRAKE. */
  private final static byte BRAKE = 0x03;

  /**
   * Initializes the Multiplexer.
   *
   * @param s the s
   */
  public RCXMotorMultiplexer(SensorPort s) {
    super(s, NXTProtocol.LOWSPEED_9V);
  }

  /**
   * Test method to retrieve macro data.
   * 
   * @return All 175 bytes right now
   */
  public byte[] getMacroData() {
    System.out.print("(Getting " + (0xFF - 0x50) + " values.)  ");
    return getData((byte) 0x50, (0xFF - 0x50));
  }

  /**
   * The Class Motor.
   */
  public class Motor {

    /** The port. */
    private byte port;
    
    /** The speed. */
    private int speed;

    /**
     * Instantiates a new motor.
     *
     * @param port the port
     */
    public Motor(int port) {
      this.port = (byte) port;
    }

    /**
     * Changes the speed to the RCX motor.
     * 
     * @param speed
     *          Value between 0 and 255 inclusive
     */
    public void setSpeed(int speed) {
      sendData(COMMAND, (byte) (MOTOR_A_SPEED + (port * 0x02)), (byte) speed);
      this.speed = speed;
    }

    /**
     * Gets the speed.
     *
     * @return the speed
     */
    public int getSpeed() {
      return this.speed;
    }

    /**
     * Backward.
     */
    public void backward() {
      // Macro commands for different motors are seperated by
      // 2 so multiply port by 0x02 to get correct motor command
      sendData(COMMAND, (byte) (MOTOR_A_DIR + (port * 0x02)), BACKWARD);
    }

    /**
     * Flt.
     */
    public void flt() {
      sendData(COMMAND, (byte) (MOTOR_A_DIR + (port * 0x02)), FLT);
    }

    /**
     * Forward.
     */
    public void forward() {
      sendData(COMMAND, (byte) (MOTOR_A_DIR + (port * 0x02)), FORWARD);
    }

    /**
     * Stop.
     */
    public void stop() {
      sendData(COMMAND, (byte) (MOTOR_A_DIR + (port * 0x02)), BRAKE);
    }
  }
}