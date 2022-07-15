package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class z {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String b = b(messageDigest.digest());
                            com.kwad.sdk.crash.utils.b.a(fileInputStream);
                            return b;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.b.b(e);
                    com.kwad.sdk.crash.utils.b.a(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.kwad.sdk.crash.utils.b.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.a(fileInputStream2);
            throw th;
        }
    }

    @NonNull
    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(byte[] bArr, int i, int i2) {
        aj.a(bArr);
        if (i2 + 0 <= bArr.length) {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + 0] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = a;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return a(digest, 0, digest.length);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            return "";
        }
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }
}
