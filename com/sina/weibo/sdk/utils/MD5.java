package com.sina.weibo.sdk.utils;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class MD5 {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String hexdigest(String str) {
        try {
            return hexdigest(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String hexdigest(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i = 0;
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = hexDigits[(b >>> 4) & 15];
                cArr[i3] = hexDigits[b & 15];
                i++;
                i2 = i3 + 1;
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] strArr) {
        System.out.println(hexdigest("c"));
    }
}
