package d.c.c.a.b.a.k;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes5.dex */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final f f65426a;

    public a(f fVar) {
        this.f65426a = fVar;
    }

    @Override // d.c.c.a.b.a.k.c
    public List<Certificate> b(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate a2 = this.f65426a.a(x509Certificate);
            if (a2 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(a2)) {
                    arrayList.add(a2);
                }
                if (c(a2, a2)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (c(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean c(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return true;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && ((a) obj).f65426a.equals(this.f65426a);
    }

    public int hashCode() {
        return this.f65426a.hashCode();
    }
}
