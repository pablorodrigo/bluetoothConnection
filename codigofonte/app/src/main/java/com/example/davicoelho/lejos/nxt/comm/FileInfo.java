package com.example.davicoelho.lejos.nxt.comm;

// TODO: Auto-generated Javadoc
/**
 * The Class FileInfo.
 */
public class FileInfo {

  /** The file name. */
  public String fileName;
  
  /** The file handle. */
  public byte fileHandle;
  
  /** The file size. */
  public int fileSize;
  
  /** The status. */
  public byte status;

  /**
   * Instantiates a new file info.
   *
   * @param fileName the file name
   */
  public FileInfo(String fileName) {
    this.fileName = fileName;
  }

}
