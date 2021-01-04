package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f7825a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(InputStream inputStream, String str) throws Exception {
        if (str == null) {
            throw new RuntimeException("md5 check failed: md5 == null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr, 0, bArr.length);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    try {
                        byte[] digest = messageDigest.digest();
                        String a2 = a(digest, 0, digest.length);
                        if (!str.equals(a2)) {
                            throw new RuntimeException("md5 check failed file: local md5:" + a2 + " expect md5:" + str);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("md5 check failed:" + e.getMessage(), e);
                    }
                } finally {
                    b.a(inputStream);
                }
            } catch (Exception e2) {
                throw new RuntimeException("md5 check failed:" + e2.getMessage(), e2);
            }
        } catch (Exception e3) {
            throw new RuntimeException("md5 check failed:" + e3.getMessage(), e3);
        }
    }

    private static String a(byte[] bArr, int i, int i2) {
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
            cArr[i3] = f7825a[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = f7825a[i5 & 15];
        }
        return new String(cArr, 0, i2 * 2);
    }
}
