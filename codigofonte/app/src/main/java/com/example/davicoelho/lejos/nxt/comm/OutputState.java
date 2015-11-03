package com.example.davicoelho.lejos.nxt.comm;

// TODO: Auto-generated Javadoc
/**
 * Container for holding the output state values.
 * 
 * @author <a href="mailto:bbagnall@mts.net">Brian Bagnall</a>
 * @version 0.2 September 9, 2006
 * @see NXTCommand
 */
public class OutputState {
  
  /** The status. */
  public byte status; // Status of the NXTCommand.getOutputState command.
  
  /** The output port. */
  public int outputPort; // (Range: 0 to 2)
  
  /** The power setpoint. */
  public byte powerSetpoint; // -100 to 100
  
  /** The mode. */
  public int mode; // (bit-field) // see NXTProtocol for enumeration
  
  /** The regulation mode. */
  public int regulationMode; // see NXTProtocol for enumeration
  
  /** The turn ratio. */
  public byte turnRatio; // -100 to 100
  
  /** The run state. */
  public int runState; // see NXTProtocol for enumeration
  
  /** The tacho limit. */
  public long tachoLimit; // Current limit on a movement in progress, if any
  
  /** The tacho count. */
  public int tachoCount; // Internal count. Number of counts since last reset of the motor counter)
  
  /** The block tacho count. */
  public int blockTachoCount; // Current position relative to last programmed movement
  
  /** The rotation count. */
  public int rotationCount; // Current position relative to last reset of the rotation sensor for

  // this motor)

  /**
   * Instantiates a new output state.
   *
   * @param port the port
   */
  public OutputState(int port) {
    outputPort = port;
  }
}