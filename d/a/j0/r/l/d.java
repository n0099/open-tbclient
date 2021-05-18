package d.a.j0.r.l;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class d {
    public d() {
        a();
    }

    public final String a() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 16; i2++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return stringBuffer.toString();
    }

    public String b(String str, String str2) throws CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        byte[] bytes = str2.getBytes("UTF-8");
        if (bytes.length % 116 == 0) {
            length = bytes.length / 116;
        } else {
            length = (bytes.length / 116) + 1;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (1 == length) {
                jSONArray.put(d.a.c.e.p.c.j(c(publicKey, bytes)));
            } else if (i2 != length - 1) {
                byte[] bArr = new byte[116];
                System.arraycopy(bytes, i2 * 116, bArr, 0, 116);
                jSONArray.put(d.a.c.e.p.c.j(c(publicKey, bArr)));
            } else {
                int i3 = i2 * 116;
                int length2 = bytes.length - i3;
                byte[] bArr2 = new byte[length2];
                System.arraycopy(bytes, i3, bArr2, 0, length2);
                jSONArray.put(d.a.c.e.p.c.j(c(publicKey, bArr2)));
            }
        }
        return d.a.c.e.p.c.j(jSONArray.toString().getBytes("UTF-8"));
    }

    public final byte[] c(Key key, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }
}
