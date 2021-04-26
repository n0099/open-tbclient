package d.a.c.g.g;

import android.content.pm.Signature;
import android.util.Base64;
import com.baidu.adp.lib.util.BdLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class a {
    public static byte[] a(Signature[] signatureArr) {
        if (signatureArr != null) {
            int i2 = 0;
            for (Signature signature : signatureArr) {
                i2 += signature.toByteArray().length;
            }
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (Signature signature2 : signatureArr) {
                byte[] byteArray = signature2.toByteArray();
                System.arraycopy(byteArray, 0, bArr, i3, byteArray.length);
                i3 += byteArray.length;
            }
            return bArr;
        }
        return null;
    }

    public static String b(byte[] bArr) {
        NoSuchAlgorithmException e2;
        String str;
        byte[] digest;
        if (bArr != null) {
            try {
                digest = MessageDigest.getInstance("MD5").digest(bArr);
            } catch (NoSuchAlgorithmException e3) {
                e2 = e3;
                str = null;
            }
            if (digest != null) {
                str = Base64.encodeToString(digest, 0);
                if (str != null) {
                    try {
                        str = str.replaceAll("\\s", "").replaceAll("\\\\", "rg").replaceAll("/", "lg");
                    } catch (NoSuchAlgorithmException e4) {
                        e2 = e4;
                        if (BdLog.isDebugMode()) {
                            e2.printStackTrace();
                        }
                        return str;
                    }
                }
                return str;
            }
            return null;
        }
        return null;
    }

    public static String c(Signature[] signatureArr) {
        byte[] a2;
        if (signatureArr == null || (a2 = a(signatureArr)) == null) {
            return null;
        }
        return b(a2);
    }
}
