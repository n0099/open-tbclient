package tv.chushou.basis.b.a.a.a;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public final class a {
    private final String ALGORITHM_NAME = "DES";
    private final String CHARSET = "utf-8";
    private final byte[] keyBytes;

    public a(String str) {
        try {
            this.keyBytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, new SecretKeySpec(this.keyBytes, "DES"));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            tv.chushou.basis.d.b.dZF().e("CipherUtil", "", e);
            return new byte[0];
        }
    }

    public byte[] decrypt(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, new SecretKeySpec(this.keyBytes, "DES"));
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            tv.chushou.basis.d.b.dZF().e("CipherUtil", "", e);
            return new byte[0];
        }
    }
}
