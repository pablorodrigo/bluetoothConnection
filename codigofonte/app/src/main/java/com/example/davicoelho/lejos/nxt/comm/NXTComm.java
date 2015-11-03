package com.example.davicoelho.lejos.nxt.comm;

// TODO: Auto-generated Javadoc
/**
 * The Interface NXTComm.
 */
public interface NXTComm {

  /**
   * Open.
   *
   * @throws Exception the exception
   */
  public void open() throws Exception;

  /**
   * Send data.
   *
   * @param request the request
   */
  public void sendData(byte[] request);

  /**
   * Read data.
   *
   * @return the byte[]
   */
  public byte[] readData();

  /**
   * Close.
   */
  public void close();

}
