package d.c.c.a.b.a.k;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes5.dex */
public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public final Map<X500Principal, Set<X509Certificate>> f66368a = new LinkedHashMap();

    public b(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.f66368a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.f66368a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // d.c.c.a.b.a.k.f
    public X509Certificate a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f66368a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && ((b) obj).f66368a.equals(this.f66368a);
    }

    public int hashCode() {
        return this.f66368a.hashCode();
    }
}
