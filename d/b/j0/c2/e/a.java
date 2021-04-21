package d.b.j0.c2.e;

import com.baidu.adp.lib.util.StringUtils;
import d.b.c.e.p.c;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class a {
    public static String a(String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(c.d(b(str2))));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            return c.j(cipher.doFinal(str.getBytes("GBK")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        return StringUtils.isNull(str) ? "" : str.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");
    }
}
