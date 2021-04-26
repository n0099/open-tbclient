package com.xiaomi.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public class bl {
    public static String a(byte b2) {
        int i2 = (b2 & ByteCompanionObject.MAX_VALUE) + (b2 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i2 < 16 ? "0" : "");
        sb.append(Integer.toHexString(i2).toLowerCase());
        return sb.toString();
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b2 : messageDigest.digest()) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }
}
