package com.bytedance.sdk.openadsdk.utils;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7892a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = bArr[i4 + i] & 255;
            int i6 = i3 + 1;
            cArr[i3] = f7892a[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = f7892a[i5 & 15];
        }
        return new String(cArr, 0, i2 * 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=5, 81=4] */
    public static String a(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String str = null;
        FileInputStream fileInputStream3 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            if (messageDigest != null) {
                fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr, 0, bArr.length);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = a(messageDigest.digest());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } else if (0 != 0) {
                try {
                    fileInputStream3.close();
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return str;
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                messageDigest.update(str.getBytes("UTF-8"));
                return a(messageDigest.digest());
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
