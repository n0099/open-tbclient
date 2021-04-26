package d.r.b.a.a.m.c.d;

import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class c {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return b(bArr, 0, bArr.length);
    }

    public static String b(byte[] bArr, int i2, int i3) {
        if (bArr == null || i2 < 0 || i3 < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i3 * 2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
            i2++;
        }
        return sb.toString();
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return d(str.getBytes());
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
