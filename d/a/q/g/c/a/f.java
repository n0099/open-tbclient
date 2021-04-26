package d.a.q.g.c.a;

import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class f {
    public static byte[] a(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes(str2));
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        return a.b(b(bArr), false);
    }
}
