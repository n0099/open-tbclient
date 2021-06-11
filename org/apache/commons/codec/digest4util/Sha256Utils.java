package org.apache.commons.codec.digest4util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
@Deprecated
/* loaded from: classes8.dex */
public class Sha256Utils {
    public static String toHash(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase(Locale.getDefault());
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }
}
