package org.apache.commons.codec.digest4util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes13.dex */
public class MD5Utils {
    private static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;

    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [82=6, 84=5, 85=4] */
    public static String toMd5(File file, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        MessageDigest messageDigest;
        String str = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            fileInputStream = null;
        } catch (IOException e2) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e3) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            str = toHexString(messageDigest.digest(), "", z);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                }
            }
        } catch (FileNotFoundException e5) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                }
            }
            return str;
        } catch (IOException e7) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                }
            }
            return str;
        } catch (NoSuchAlgorithmException e9) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e10) {
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                }
            }
            throw th;
        }
        return str;
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
