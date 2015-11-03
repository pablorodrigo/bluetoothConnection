package com.example.davicoelho.lejos.nxt;

import icommand.nxt.comm.InputValues;
import icommand.nxt.comm.NXTCommand;
import icommand.nxt.comm.NXTProtocol;

// TODO: Auto-generated Javadoc

/**
 * Port class. Contains 4 Port instances.<br>
 * Usage: Port.S4.readValue();
 * 
 * @author <a href="mailto:bbagnall@mts.net">Brian Bagnall</a>
 * @version 0.3 29-October-2006
 * 
 */
public class SensorPort implements NXTProtocol {

  /** The Constant nxtCommand. */
  private static final NXTCommand nxtCommand = NXTCommand.getSingleton();

  /** The id. */
  private int id;

  /** The S1. */
  public static SensorPort S1 = new SensorPort(0);
  
  /** The S2. */
  public static SensorPort S2 = new SensorPort(1);
  
  /** The S3. */
  public static SensorPort S3 = new SensorPort(2);
  
  /** The S4. */
  public static SensorPort S4 = new SensorPort(3);

  /**
   * Instantiates a new sensor port.
   *
   * @param port the port
   */
  private SensorPort(int port) {
    id = port;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the type and mode.
   *
   * @param type the type
   * @param mode the mode
   */
  public void setTypeAndMode(int type, int mode) {
    nxtCommand.setInputMode(id, type, mode);
  }

  /**
   * Reads the boolean value of the sensor.
   * 
   * @return Boolean value of sensor.
   */
  public boolean readBooleanValue() {
    InputValues vals = nxtCommand.getInputValues(id);
    // I thought open sensor would produce 0 value. My UWORD conversion wrong?
    return (vals.rawADValue < 500);
  }

  /**
   * Reads the raw value of the sensor.
   * 
   * @return Raw sensor value. Range is device dependent.
   */
  public int readRawValue() {
    InputValues vals = nxtCommand.getInputValues(id);
    return vals.rawADValue;
  }

  /**
   * Reads the normalized value of the sensor.
   * 
   * @return Normalized value. 0 to 1023
   */
  public int readNormalizedValue() {
    InputValues vals = nxtCommand.getInputValues(id);
    return vals.normalizedADValue;
  }

  /**
   * Returns scaled value, depending on mode of sensor. e.g. BOOLEANMODE returns 0 or 1. e.g.
   * PCTFULLSCALE returns 0 to 100.
   *
   * @return the int
   * @see SensorPort#setTypeAndMode(int, int)
   */
  public int readScaledValue() {
    InputValues vals = nxtCommand.getInputValues(id);
    return vals.scaledValue;
  }
}
