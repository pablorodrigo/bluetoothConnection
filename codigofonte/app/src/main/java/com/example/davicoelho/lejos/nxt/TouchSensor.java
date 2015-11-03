package com.example.davicoelho.lejos.nxt;

import icommand.nxt.comm.NXTProtocol;

// TODO: Auto-generated Javadoc

/**
 * TouchSensor Port class.
 * 
 * @author BB
 * 
 */
public class TouchSensor {

  /** The sensor. */
  SensorPort sensor;

  /**
   * Instantiates a new touch sensor.
   *
   * @param sensor the sensor
   */
  public TouchSensor(SensorPort sensor) {
    this.sensor = sensor;
    sensor.setTypeAndMode(NXTProtocol.SWITCH, NXTProtocol.BOOLEANMODE);
  }

  /**
   * Checks if is pressed.
   *
   * @return true if sensor is pressed.
   */
  public boolean isPressed() {
    return (sensor.readScaledValue() == 1);
  }
}
