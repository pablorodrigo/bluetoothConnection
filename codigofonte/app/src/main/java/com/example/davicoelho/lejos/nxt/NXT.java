package com.example.davicoelho.lejos.nxt;

import icommand.nxt.comm.DeviceInfo;
import icommand.nxt.comm.FirmwareInfo;
import icommand.nxt.comm.NXTCommand;

// TODO: Auto-generated Javadoc

/**
 * The Class NXT.
 */
public class NXT {

  /** The nxt command. */
  private static NXTCommand nxtCommand = NXTCommand.getSingleton();

  /**
   * Gets the firmware version.
   *
   * @return the firmware version
   */
  public static float getFirmwareVersion() {
    FirmwareInfo f = nxtCommand.getFirmwareVersion();
    return Float.parseFloat(f.firmwareVersion);
  }

  /**
   * Gets the protocol version.
   *
   * @return the protocol version
   */
  public static float getProtocolVersion() {
    FirmwareInfo f = nxtCommand.getFirmwareVersion();
    return Float.parseFloat(f.protocolVersion);
  }

  /**
   * Gets the flash memory.
   *
   * @return Free memory remaining in FLASH
   */
  public static int getFlashMemory() {
    DeviceInfo i = nxtCommand.getDeviceInfo();
    return i.freeFlash;
  }

  /**
   * Deletes all user programs and data in FLASH memory.
   *
   * @return the byte
   */
  public static byte deleteFlashMemory() {
    return nxtCommand.deleteUserFlash();
  }

  /**
   * Gets the brick name.
   *
   * @return the brick name
   */
  public static String getBrickName() {
    DeviceInfo i = nxtCommand.getDeviceInfo();
    return i.NXTname;
  }

  /**
   * Sets the brick name.
   *
   * @param newName the new name
   * @return the byte
   */
  public static byte setBrickName(String newName) {
    return nxtCommand.setBrickName(newName);
  }

  /**
   * This doesn't seem to be implemented in Lego NXT firmware/protocol?.
   *
   * @return Seems to return 0 every time
   */
  public static int getSignalStrength() {
    DeviceInfo i = nxtCommand.getDeviceInfo();
    return i.signalStrength;
  }
}
