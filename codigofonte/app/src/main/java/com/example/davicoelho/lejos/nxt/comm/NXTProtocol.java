package com.example.davicoelho.lejos.nxt.comm;

// TODO: Auto-generated Javadoc
/**
 * The Interface NXTProtocol.
 */
public interface NXTProtocol {

  // Command types constants. Indicates type of packet being sent or received.
  /** The DIREC t_ comman d_ reply. */
  public static byte DIRECT_COMMAND_REPLY = 0x00;
  
  /** The SYSTE m_ comman d_ reply. */
  public static byte SYSTEM_COMMAND_REPLY = 0x01;
  
  /** The REPL y_ command. */
  public static byte REPLY_COMMAND = 0x02;
  
  /** The DIREC t_ comman d_ noreply. */
  public static byte DIRECT_COMMAND_NOREPLY = (byte) 0x80; // Avoids ~100ms latency
  
  /** The SYSTE m_ comman d_ noreply. */
  public static byte SYSTEM_COMMAND_NOREPLY = (byte) 0x81; // Avoids ~100ms latency

  // System Commands:
  /** The OPE n_ read. */
  public static byte OPEN_READ = (byte) 0x80;
  
  /** The OPE n_ write. */
  public static byte OPEN_WRITE = (byte) 0x81;
  
  /** The READ. */
  public static byte READ = (byte) 0x82;
  
  /** The WRITE. */
  public static byte WRITE = (byte) 0x83;
  
  /** The CLOSE. */
  public static byte CLOSE = (byte) 0x84;
  
  /** The DELETE. */
  public static byte DELETE = (byte) 0x85;
  
  /** The FIN d_ first. */
  public static byte FIND_FIRST = (byte) 0x86;
  
  /** The FIN d_ next. */
  public static byte FIND_NEXT = (byte) 0x87;
  
  /** The GE t_ firmwar e_ version. */
  public static byte GET_FIRMWARE_VERSION = (byte) 0x88;
  
  /** The OPE n_ writ e_ linear. */
  public static byte OPEN_WRITE_LINEAR = (byte) 0x89;
  
  /** The OPE n_ rea d_ linear. */
  public static byte OPEN_READ_LINEAR = (byte) 0x8A;
  
  /** The OPE n_ writ e_ data. */
  public static byte OPEN_WRITE_DATA = (byte) 0x8B;
  
  /** The OPE n_ appen d_ data. */
  public static byte OPEN_APPEND_DATA = (byte) 0x8C;
  // Many commands could be hidden between 0x8D and 0x96!
  /** The BOOT. */
  public static byte BOOT = (byte) 0x97;
  
  /** The SE t_ bric k_ name. */
  public static byte SET_BRICK_NAME = (byte) 0x98;
  // public static byte MYSTERY_COMMAND = (byte)0x99;
  // public static byte MYSTERY_COMMAND = (byte)0x9A;
  /** The GE t_ devic e_ info. */
  public static byte GET_DEVICE_INFO = (byte) 0x9B;
  // commands could be hidden here...
  /** The DELET e_ use r_ flash. */
  public static byte DELETE_USER_FLASH = (byte) 0xA0;
  
  /** The POL l_ length. */
  public static byte POLL_LENGTH = (byte) 0xA1;
  
  /** The POLL. */
  public static byte POLL = (byte) 0xA2;

  // Poll constants:
  /** The POL l_ buffer. */
  public static byte POLL_BUFFER = (byte) 0x00;
  
  /** The HIG h_ spee d_ buffer. */
  public static byte HIGH_SPEED_BUFFER = (byte) 0x01;

  // Direct Commands
  /** The STAR t_ program. */
  public static byte START_PROGRAM = 0x00;
  
  /** The STO p_ program. */
  public static byte STOP_PROGRAM = 0x01;
  
  /** The PLA y_ soun d_ file. */
  public static byte PLAY_SOUND_FILE = 0x02;
  
  /** The PLA y_ tone. */
  public static byte PLAY_TONE = 0x03;
  
  /** The SE t_ outpu t_ state. */
  public static byte SET_OUTPUT_STATE = 0x04;
  
  /** The SE t_ inpu t_ mode. */
  public static byte SET_INPUT_MODE = 0x05;
  
  /** The GE t_ outpu t_ state. */
  public static byte GET_OUTPUT_STATE = 0x06;
  
  /** The GE t_ inpu t_ values. */
  public static byte GET_INPUT_VALUES = 0x07;
  
  /** The RESE t_ scale d_ inpu t_ value. */
  public static byte RESET_SCALED_INPUT_VALUE = 0x08;
  
  /** The MESSAG e_ write. */
  public static byte MESSAGE_WRITE = 0x09;
  
  /** The RESE t_ moto r_ position. */
  public static byte RESET_MOTOR_POSITION = 0x0A;
  
  /** The GE t_ batter y_ level. */
  public static byte GET_BATTERY_LEVEL = 0x0B;
  
  /** The STO p_ soun d_ playback. */
  public static byte STOP_SOUND_PLAYBACK = 0x0C;
  
  /** The KEE p_ alive. */
  public static byte KEEP_ALIVE = 0x0D;
  
  /** The L s_ ge t_ status. */
  public static byte LS_GET_STATUS = 0x0E;
  
  /** The L s_ write. */
  public static byte LS_WRITE = 0x0F;
  
  /** The L s_ read. */
  public static byte LS_READ = 0x10;
  
  /** The GE t_ curren t_ progra m_ name. */
  public static byte GET_CURRENT_PROGRAM_NAME = 0x11;
  // public static byte MYSTERY_OPCODE = 0x12; // ????
  /** The MESSAG e_ read. */
  public static byte MESSAGE_READ = 0x13;
  // public static byte POSSIBLY_MORE_HIDDEN = 0x14; // ????

  // Custom leJOS NXJ commands:
  /** The NX j_ disconnect. */
  public static byte NXJ_DISCONNECT = 0x20;
  
  /** The NX j_ defrag. */
  public static byte NXJ_DEFRAG = 0x21;

  // Output state constants
  // �Mode�:
  /** Turn on the specified motor. */
  public static byte MOTORON = 0x01;
  
  /** Use run/brake instead of run/float in PWM. */
  public static byte BRAKE = 0x02;
  
  /** Turns on the regulation. */
  public static byte REGULATED = 0x04;

  // �Regulation Mode�:
  /** No regulation will be enabled. */
  public static byte REGULATION_MODE_IDLE = 0x00;
  
  /** Power control will be enabled on specified output. */
  public static byte REGULATION_MODE_MOTOR_SPEED = 0x01;
  
  /** Synchronization will be enabled (Needs enabled on two output). */
  public static byte REGULATION_MODE_MOTOR_SYNC = 0x02;

  // �RunState�:
  /** Output will be idle. */
  public static byte MOTOR_RUN_STATE_IDLE = 0x00;
  
  /** Output will ramp-up. */
  public static byte MOTOR_RUN_STATE_RAMPUP = 0x10;
  
  /** Output will be running. */
  public static byte MOTOR_RUN_STATE_RUNNING = 0x20;
  
  /** Output will ramp-down. */
  public static byte MOTOR_RUN_STATE_RAMPDOWN = 0x40;

  // Input Mode Constants
  // �Port Type�:
  /** The N o_ sensor. */
  public static byte NO_SENSOR = 0x00;
  
  /** The SWITCH. */
  public static byte SWITCH = 0x01;
  
  /** The TEMPERATURE. */
  public static byte TEMPERATURE = 0x02;
  
  /** The REFLECTION. */
  public static byte REFLECTION = 0x03;
  
  /** The ANGLE. */
  public static byte ANGLE = 0x04;
  
  /** The LIGH t_ active. */
  public static byte LIGHT_ACTIVE = 0x05;
  
  /** The LIGH t_ inactive. */
  public static byte LIGHT_INACTIVE = 0x06;
  
  /** The SOUN d_ db. */
  public static byte SOUND_DB = 0x07;
  
  /** The SOUN d_ dba. */
  public static byte SOUND_DBA = 0x08;
  
  /** The CUSTOM. */
  public static byte CUSTOM = 0x09;
  
  /** The LOWSPEED. */
  public static byte LOWSPEED = 0x0A;
  
  /** The LOWSPEE d_9 v. */
  public static byte LOWSPEED_9V = 0x0B;
  
  /** The N o_ o f_ senso r_ types. */
  public static byte NO_OF_SENSOR_TYPES = 0x0C;

  // �Port Mode�:
  /** The RAWMODE. */
  public static byte RAWMODE = 0x00;
  
  /** The BOOLEANMODE. */
  public static byte BOOLEANMODE = 0x20;
  
  /** The TRANSITIONCNTMODE. */
  public static byte TRANSITIONCNTMODE = 0x40;
  
  /** The PERIODCOUNTERMODE. */
  public static byte PERIODCOUNTERMODE = 0x60;
  
  /** The PCTFULLSCALEMODE. */
  public static byte PCTFULLSCALEMODE = (byte) 0x80;
  
  /** The CELSIUSMODE. */
  public static byte CELSIUSMODE = (byte) 0xA0;
  
  /** The FAHRENHEITMODE. */
  public static byte FAHRENHEITMODE = (byte) 0xC0;
  
  /** The ANGLESTEPSMODE. */
  public static byte ANGLESTEPSMODE = (byte) 0xE0;
  
  /** The SLOPEMASK. */
  public static byte SLOPEMASK = 0x1F;
  
  /** The MODEMASK. */
  public static byte MODEMASK = (byte) 0xE0;

}
