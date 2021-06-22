package d.a.k0.l;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class a {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[i2] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] doFinal = cipher.doFinal(bArr2);
            byte[] e2 = g.e(bArr2);
            byte[] bArr4 = new byte[doFinal.length + e2.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(e2, 0, bArr4, doFinal.length, e2.length);
            return bArr4;
        } catch (Throwable th) {
            c.d(th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[i2] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable unused) {
            return null;
        }
    }
}
