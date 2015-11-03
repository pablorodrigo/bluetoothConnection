package com.example.davicoelho.lejos.nxt.comm;

import java.io.UnsupportedEncodingException;

// TODO: Auto-generated Javadoc
/* ASCIIZ is ASCII terminated by Zero */

/**
 * The Class AsciizCodec.
 */
public class AsciizCodec {

  /** The Constant CHARSET. */
  private static final String CHARSET = "US-ASCII";

  /**
   * Instantiates a new asciiz codec.
   */
  private AsciizCodec() {
  }

  /**
   * Encode.
   *
   * @param str the str
   * @return the byte[]
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public static byte[] encode(String str) throws UnsupportedEncodingException {
    // Encode string with ASCII charset
    byte[] ascii = str.getBytes(CHARSET);

    // Append Zero byte

    byte[] asciiz = new byte[ascii.length + 1];
    System.arraycopy(ascii, 0, asciiz, 0, ascii.length);
    System.arraycopy(new byte[]{0x00}, 0, asciiz, asciiz.length - 1, 1);

    return asciiz;
  }

  /**
   * Decode.
   *
   * @param bytes the bytes
   * @return the string
   * @throws UnsupportedEncodingException the unsupported encoding exception
   */
  public static String decode(final byte[] bytes) throws UnsupportedEncodingException {
    byte lastByte = bytes[bytes.length - 1];
    if (lastByte != 0x00) {
      throw new UnsupportedEncodingException("Last byte of ASCIIZ encoded string must be Zero");
    }

    // Remove Last byte
    byte[] ascii = new byte[bytes.length - 1];
    System.arraycopy(bytes, 0, ascii, 0, bytes.length - 1);

    // Decode bytes with ASCII scharset
    return new String(ascii, CHARSET);
  }
}
