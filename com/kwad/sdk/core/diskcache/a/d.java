package com.kwad.sdk.core.diskcache.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public final class d {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
