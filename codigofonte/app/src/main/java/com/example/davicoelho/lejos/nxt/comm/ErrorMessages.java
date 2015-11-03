package com.example.davicoelho.lejos.nxt.comm;

// TODO: Auto-generated Javadoc
/**
 * Error messages that can be returned after a call to the NXT brick. e.g. The return value comes
 * from method calls like Motor.backward(), SoundSensor.playTone(), etc... Actual values are only
 * returned if you enable validation in the NXT class using NXT.setValidation().
 * 
 * @author <a href="mailto:bbagnall@mts.net">Brian Bagnall</a>
 * 
 */

public interface ErrorMessages {

  // Direct communication errors:
  /** The Constant PENDING_COMMUNICATION_TRANSACTION_IN_PROGRESS. */
  public static final byte PENDING_COMMUNICATION_TRANSACTION_IN_PROGRESS = 0x20;
  
  /** The Constant SPECIFIED_MAILBOX_QUEUE_IS_EMPTY. */
  public static final byte SPECIFIED_MAILBOX_QUEUE_IS_EMPTY = 0x40;
  /** Request failed (i.e. specified file not found) */
  public static final byte REQUEST_FAILED = (byte) 0xBD;
  
  /** The Constant UNKNOWN_COMMAND_OPCODE. */
  public static final byte UNKNOWN_COMMAND_OPCODE = (byte) 0xBE;
  
  /** The Constant INSANE_PACKET. */
  public static final byte INSANE_PACKET = (byte) 0xBF;
  
  /** The Constant DATA_CONTAINS_OUT_OF_RANGE_VALUES. */
  public static final byte DATA_CONTAINS_OUT_OF_RANGE_VALUES = (byte) 0xC0;
  
  /** The Constant COMMUNICATION_BUS_ERROR. */
  public static final byte COMMUNICATION_BUS_ERROR = (byte) 0xDD;
  
  /** The Constant NO_FREE_MEMORY_IN_COMMUNICATION_BUFFER. */
  public static final byte NO_FREE_MEMORY_IN_COMMUNICATION_BUFFER = (byte) 0xDE;
  
  /** Specified channel/connection is not valid. */
  public static final byte SPECIFIED_CHANNEL_CONNECTION_IS_NOT_VALID = (byte) 0xDF;
  
  /** Specified channel/connection not configured or busy. */
  public static final byte SPECIFIED_CHANNEL_CONNECTION_NOT_CONFIGURED_OR_BUSY = (byte) 0xE0;
  
  /** The Constant NO_ACTIVE_PROGRAM. */
  public static final byte NO_ACTIVE_PROGRAM = (byte) 0xEC;
  
  /** The Constant ILLEGAL_SIZE_SPECIFIED. */
  public static final byte ILLEGAL_SIZE_SPECIFIED = (byte) 0xED;
  
  /** The Constant ILLEGAL_MAILBOX_QUEUE_ID_SPECIFIED. */
  public static final byte ILLEGAL_MAILBOX_QUEUE_ID_SPECIFIED = (byte) 0xEE;
  
  /** The Constant ATTEMPTED_TO_ACCESS_INVALID_FIELD_OF_A_STRUCTURE. */
  public static final byte ATTEMPTED_TO_ACCESS_INVALID_FIELD_OF_A_STRUCTURE = (byte) 0xEF;
  
  /** The Constant BAD_INPUT_OR_OUTPUT_SPECIFIED. */
  public static final byte BAD_INPUT_OR_OUTPUT_SPECIFIED = (byte) 0xF0;
  
  /** The Constant INSUFFICIENT_MEMORY_AVAILABLE. */
  public static final byte INSUFFICIENT_MEMORY_AVAILABLE = (byte) 0xFB;
  
  /** The Constant BAD_ARGUMENTS. */
  public static final byte BAD_ARGUMENTS = (byte) 0xFF;

  // Communication protocol errors:
  /** The Constant SUCCESS. */
  public static final byte SUCCESS = 0x00;
  
  /** The Constant NO_MORE_HANDLES. */
  public static final byte NO_MORE_HANDLES = (byte) 0x81;
  
  /** The Constant NO_SPACE. */
  public static final byte NO_SPACE = (byte) 0x82;
  
  /** The Constant NO_MORE_FILES. */
  public static final byte NO_MORE_FILES = (byte) 0x83;
  
  /** The Constant END_OF_FILE_EXPECTED. */
  public static final byte END_OF_FILE_EXPECTED = (byte) 0x84;
  
  /** The Constant END_OF_FILE. */
  public static final byte END_OF_FILE = (byte) 0x85;
  
  /** The Constant NOT_A_LINEAR_FILE. */
  public static final byte NOT_A_LINEAR_FILE = (byte) 0x86;
  
  /** The Constant FILE_NOT_FOUND. */
  public static final byte FILE_NOT_FOUND = (byte) 0x87;
  
  /** The Constant HANDLE_ALREADY_CLOSED. */
  public static final byte HANDLE_ALREADY_CLOSED = (byte) 0x88;
  
  /** The Constant NO_LINEAR_SPACE. */
  public static final byte NO_LINEAR_SPACE = (byte) 0x89;
  
  /** The Constant UNDEFINED_ERROR. */
  public static final byte UNDEFINED_ERROR = (byte) 0x8A;
  
  /** The Constant FILE_IS_BUSY. */
  public static final byte FILE_IS_BUSY = (byte) 0x8B;
  
  /** The Constant NO_WRITE_BUFFERS. */
  public static final byte NO_WRITE_BUFFERS = (byte) 0x8C;
  
  /** The Constant APPEND_NOT_POSSIBLE. */
  public static final byte APPEND_NOT_POSSIBLE = (byte) 0x8D;
  
  /** The Constant FILE_IS_FULL. */
  public static final byte FILE_IS_FULL = (byte) 0x8E;
  
  /** The Constant FILE_EXISTS. */
  public static final byte FILE_EXISTS = (byte) 0x8F;
  
  /** The Constant MODULE_NOT_FOUND. */
  public static final byte MODULE_NOT_FOUND = (byte) 0x90;
  
  /** The Constant OUT_OF_BOUNDARY. */
  public static final byte OUT_OF_BOUNDARY = (byte) 0x91;
  
  /** The Constant ILLEGAL_FILE_NAME. */
  public static final byte ILLEGAL_FILE_NAME = (byte) 0x92;
  
  /** The Constant ILLEGAL_HANDLE. */
  public static final byte ILLEGAL_HANDLE = (byte) 0x93;
}
