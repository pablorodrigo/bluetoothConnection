package com.example.davicoelho.lejos.nxt;

import icommand.nxt.comm.NXTCommand;

// TODO: Auto-generated Javadoc

/**
 * The message class is used to send messages between NXT bricks. UNTESTED
 * 
 * @author BB
 * 
 */
public class Inbox {

  /** The Constant nxtCommand. */
  private static final NXTCommand nxtCommand = NXTCommand.getSingleton();

  /**
   * Send message.
   *
   * @param message the message
   * @param inbox the inbox
   * @return the int
   */
  public static int sendMessage(byte[] message, int inbox) {
    return nxtCommand.messageWrite(message, (byte) inbox);
  }

  /**
   * Receive message.
   *
   * @param remoteInbox the remote inbox
   * @param localInbox the local inbox
   * @param remove the remove
   * @return the byte[]
   */
  public static byte[] receiveMessage(int remoteInbox, int localInbox, boolean remove) {
    return nxtCommand.messageRead((byte) remoteInbox, (byte) localInbox, remove);
  }

}
