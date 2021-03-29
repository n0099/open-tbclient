package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f30348a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(InputStream inputStream, String str) throws Exception {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        try {
                            byte[] digest = messageDigest.digest();
                            String a2 = a(digest, 0, digest.length);
                            if (str.equals(a2)) {
                                return;
                            }
                            throw new RuntimeException("md5 check failed file: local md5:" + a2 + " expect md5:" + str);
                        } catch (Exception e2) {
                            throw new RuntimeException("md5 check failed:" + e2.getMessage(), e2);
                        }
                    } catch (Exception e3) {
                        throw new RuntimeException("md5 check failed:" + e3.getMessage(), e3);
                    }
                } finally {
                    b.a(inputStream);
                }
            } catch (Exception e4) {
                throw new RuntimeException("md5 check failed:" + e4.getMessage(), e4);
            }
        }
        throw new RuntimeException("md5 check failed: md5 == null");
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bArr[i5 + i] & 255;
                    int i7 = i4 + 1;
                    char[] cArr2 = f30348a;
                    cArr[i4] = cArr2[i6 >> 4];
                    i4 = i7 + 1;
                    cArr[i7] = cArr2[i6 & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }
}
