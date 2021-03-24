package d.b.n0.a;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes5.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public PublicKey f64153a;

    public c(String str) throws Exception {
        b(str);
    }

    @Override // d.b.n0.a.a
    public String a(String str) throws Exception {
        if (!d.b.n0.c.a.a(str)) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f64153a);
            return d.b.n0.b.a.r(cipher.doFinal(str.getBytes()));
        }
        throw new Exception("Plaintext can not be blank.");
    }

    public final void b(String str) throws Exception {
        if (!d.b.n0.c.a.a(str)) {
            this.f64153a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(d.b.n0.b.a.n(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
            return;
        }
        throw new Exception("PubKey can not be blank.");
    }
}
