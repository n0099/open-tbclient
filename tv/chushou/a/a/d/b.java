package tv.chushou.a.a.d;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public final class b {
    public static String encrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bArr = null;
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes(tv.chushou.a.a.a.a.UTF_8));
        } catch (NoSuchAlgorithmException e) {
        }
        return toHexString(bArr);
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(new BigInteger(1, bArr).toString(16));
        while (sb.length() < 32) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
