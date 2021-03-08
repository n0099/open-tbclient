package com.tencent.mm.a;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class a {
    public static final String a(byte[] bArr) {
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
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i3 + 1;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }
}
