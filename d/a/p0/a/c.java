package d.a.p0.a;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes5.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public PublicKey f64135a;

    public c(String str) throws Exception {
        b(str);
    }

    @Override // d.a.p0.a.a
    public String a(String str) throws Exception {
        if (!d.a.p0.c.a.a(str)) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f64135a);
            return d.a.p0.b.a.r(cipher.doFinal(str.getBytes()));
        }
        throw new Exception("Plaintext can not be blank.");
    }

    public final void b(String str) throws Exception {
        if (!d.a.p0.c.a.a(str)) {
            this.f64135a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(d.a.p0.b.a.n(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
            return;
        }
        throw new Exception("PubKey can not be blank.");
    }
}
