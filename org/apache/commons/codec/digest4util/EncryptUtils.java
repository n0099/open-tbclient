package org.apache.commons.codec.digest4util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes16.dex */
public class EncryptUtils {
    private static final boolean DEBUG = false;
    public static final String ENCRYPT_MD5 = "MD5";
    public static final String ENCRYPT_SHA1 = "SHA-1";
    public static final String ENCRYPT_SHA256 = "SHA-256";
    public static final String ENCRYPT_SHA384 = "SHA-384";
    public static final String ENCRYPT_SHA512 = "SHA-512";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;

    public static String encrypt(String str, byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=6, 85=5, 86=4] */
    public static String encrypt(String str, File file, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        String str2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str2 = toHexString(messageDigest.digest(), "", z);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return str2;
            } catch (IOException e4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                return str2;
            } catch (NoSuchAlgorithmException e6) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                    }
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileInputStream = null;
        } catch (IOException e10) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e11) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        return str2;
    }

    private static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}
