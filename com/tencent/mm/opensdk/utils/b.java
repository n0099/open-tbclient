package com.tencent.mm.opensdk.utils;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class b {
    public static final String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            char[] cArr2 = new char[length * 2];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b2 = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                cArr2[i3] = cArr[b2 & 15];
                i++;
                i2 = i3 + 1;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }
}
