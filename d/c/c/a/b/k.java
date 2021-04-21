package d.c.c.a.b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.CertificatePinner;
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f66436c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f66437a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.c.a.b.a.k.c f66438b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f66439a = new ArrayList();

        public k a() {
            return new k(new LinkedHashSet(this.f66439a), null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f66440a;

        /* renamed from: b  reason: collision with root package name */
        public final String f66441b;

        /* renamed from: c  reason: collision with root package name */
        public final String f66442c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bytedance.sdk.a.a.f f66443d;

        public boolean a(String str) {
            if (this.f66440a.startsWith(CertificatePinner.Pin.WILDCARD)) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f66441b.length()) {
                    String str2 = this.f66441b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f66441b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f66440a.equals(bVar.f66440a) && this.f66442c.equals(bVar.f66442c) && this.f66443d.equals(bVar.f66443d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f66440a.hashCode()) * 31) + this.f66442c.hashCode()) * 31) + this.f66443d.hashCode();
        }

        public String toString() {
            return this.f66442c + this.f66443d.b();
        }
    }

    public k(Set<b> set, d.c.c.a.b.a.k.c cVar) {
        this.f66437a = set;
        this.f66438b = cVar;
    }

    public static com.bytedance.sdk.a.a.f a(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + f((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static com.bytedance.sdk.a.a.f f(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public k b(d.c.c.a.b.a.k.c cVar) {
        return d.c.c.a.b.a.e.u(this.f66438b, cVar) ? this : new k(this.f66437a, cVar);
    }

    public List<b> d(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f66437a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public void e(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> d2 = d(str);
        if (d2.isEmpty()) {
            return;
        }
        d.c.c.a.b.a.k.c cVar = this.f66438b;
        if (cVar != null) {
            list = cVar.b(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = d2.size();
            com.bytedance.sdk.a.a.f fVar = null;
            com.bytedance.sdk.a.a.f fVar2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = d2.get(i2);
                if (bVar.f66442c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = f(x509Certificate);
                    }
                    if (bVar.f66443d.equals(fVar)) {
                        return;
                    }
                } else if (bVar.f66442c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f66443d.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f66442c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = d2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(d2.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (d.c.c.a.b.a.e.u(this.f66438b, kVar.f66438b) && this.f66437a.equals(kVar.f66437a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        d.c.c.a.b.a.k.c cVar = this.f66438b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f66437a.hashCode();
    }
}
