package e.a.q;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public final class c {
    public static synchronized String a(byte[] bArr) {
        String sb;
        synchronized (c.class) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder();
                for (byte b2 : digest) {
                    sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                }
                sb = sb2.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return sb;
    }

    public static String b(String str) {
        if (str != null) {
            try {
                return a(str.getBytes("GBK"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
