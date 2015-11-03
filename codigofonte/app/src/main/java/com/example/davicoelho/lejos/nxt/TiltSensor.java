package com.example.davicoelho.lejos.nxt;

import icommand.nxt.comm.NXTProtocol;

// TODO: Auto-generated Javadoc
// !! Dick Swan mentioned: RCX firmware has a bug that requires a 30 msec 
// delay between messages to reliably work. Seems to work fine though.
// Make private helper method that ensures 30msec has elapsed?

/**
 * TiltSensor by Mindsensors.com. Works with: ACCL-Nx-3g3x UNTESTED: ACCL-Nx-2g2x, ACCL-Nx-5g2x
 * 
 * @author BB
 */
public class TiltSensor extends I2CSensor {

  /** The X_ tilt. */
  private static byte X_TILT = 0x42;
  
  /** The Y_ tilt. */
  private static byte Y_TILT = 0x43;
  
  /** The Z_ tilt. */
  private static byte Z_TILT = 0x44;

  /** The X_ acce l_ lsb. */
  private static byte X_ACCEL_LSB = 0x45;
  
  /** The Y_ acce l_ lsb. */
  private static byte Y_ACCEL_LSB = 0x47;
  
  /** The Z_ acce l_ lsb. */
  private static byte Z_ACCEL_LSB = 0x49;

  /**
   * Instantiates a new tilt sensor.
   *
   * @param s the s
   */
  public TiltSensor(SensorPort s) {
    super(s, NXTProtocol.LOWSPEED_9V);
  }

  /**
   * Tilt of sensor along X-axis (see top of Mindsensors.com sensor for diagram of axis). 128 is
   * level.
   *
   * @return the x tilt
   */
  public int getXTilt() {
    byte[] val = getData(X_TILT, 1);
    return 0xFF & val[0];
  }

  /**
   * Gets the y tilt.
   *
   * @return the y tilt
   */
  public int getYTilt() {
    byte[] val = getData(Y_TILT, 1);
    return 0xFF & val[0];
  }

  /**
   * Gets the z tilt.
   *
   * @return the z tilt
   */
  public int getZTilt() {
    byte[] val = getData(Z_TILT, 1);
    return 0xFF & val[0];
  }

  /**
   * Acceleration along X axis. Positive or negative values in mg. (g = acceleration due to gravity
   * = 9.81 m/s^2)
   * 
   * @return Acceleration e.g. 9810 mg (falling on earth)
   */
  public int getXAccel() {
    byte[] vals = getData(X_ACCEL_LSB, 2);
    // System.out.print("LSB = " + vals[0] + "  MSB = " + vals[1] + "   ");
    int accel = (vals[0]) | ((vals[1]) << 8);
    return accel;
  }

  /**
   * Gets the y accel.
   *
   * @return the y accel
   */
  public int getYAccel() {
    byte[] vals = getData(Y_ACCEL_LSB, 2);
    // System.out.print("LSB = " + vals[0] + "  MSB = " + vals[1] + "   ");
    int accel = (vals[0]) | ((vals[1]) << 8);
    return accel;
  }

  /**
   * Gets the z accel.
   *
   * @return the z accel
   */
  public int getZAccel() {
    byte[] vals = getData(Z_ACCEL_LSB, 2);
    // System.out.print("LSB = " + vals[0] + "  MSB = " + vals[1] + "   ");
    int accel = (vals[0]) | ((vals[1]) << 8);
    return accel;
  }

  /**
   * Method to return all acceleration data in one call NOT AS RELIABLE AS GETTING INDIVIDUAL
   * VALUES!!!.
   *
   * @return the accel data
   */
  public AccelData getAccelData() {
    byte[] vals = getData(X_TILT, 9);
    AccelData a = new AccelData();
    // Now plug all these values into AccellData object
    a.xTilt = 0xFF & vals[0];
    a.yTilt = 0xFF & vals[1];
    a.zTilt = 0xFF & vals[2];
    a.xAccel = vals[3] | (vals[4]) << 8;
    a.yAccel = vals[5] | (vals[6]) << 8;
    a.zAccel = vals[7] | (vals[8]) << 8;

    return a;
  }

  /**
   * The Class AccelData.
   */
  public class AccelData {
    
    /** The x tilt. */
    public int xTilt;
    
    /** The y tilt. */
    public int yTilt;
    
    /** The z tilt. */
    public int zTilt;

    /** The x accel. */
    public int xAccel;
    
    /** The y accel. */
    public int yAccel;
    
    /** The z accel. */
    public int zAccel;
  }
}