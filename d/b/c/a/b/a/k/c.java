package d.b.c.a.b.a.k;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public abstract class c {
    public static c a(X509TrustManager x509TrustManager) {
        return d.b.c.a.b.a.i.e.j().b(x509TrustManager);
    }

    public abstract List<Certificate> b(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
