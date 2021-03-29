package d.b.f0.l;

import android.content.Context;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class e {
    public static String a(Context context, String str) {
        if (context != null && str != null) {
            try {
                return new String(a.b(c.i(context).getBytes(), Base64.decode(str, 0), true));
            } catch (Throwable th) {
                c.d(th);
            }
        }
        return null;
    }

    public static String b(Context context, byte[] bArr) {
        byte[] a2;
        if (bArr != null) {
            try {
                if (bArr.length != 0 && (a2 = a.a(c.i(context).getBytes(), bArr)) != null && a2.length > 0) {
                    return Base64.encodeToString(a2, 0);
                }
                return null;
            } catch (Throwable th) {
                c.d(th);
            }
        }
        return null;
    }

    public static String c(byte[] bArr, String str) {
        try {
            RSAPublicKey d2 = d(str);
            if (d2 == null) {
                return "";
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, d2);
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Throwable th) {
            c.d(th);
            return "";
        }
    }

    public static RSAPublicKey d(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable th) {
            c.d(th);
            return null;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = a.b(bArr2, bArr, true)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
        return bArr3;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = a.a(bArr2, bArr)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
        return bArr3;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = i.b(bArr, bArr2)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
        return bArr3;
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = i.c(bArr, bArr2)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
        return bArr3;
    }
}
