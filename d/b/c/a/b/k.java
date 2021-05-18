package d.b.c.a.b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.CertificatePinner;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f65511c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f65512a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.c.a.b.a.k.c f65513b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f65514a = new ArrayList();

        public k a() {
            return new k(new LinkedHashSet(this.f65514a), null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f65515a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65516b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65517c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bytedance.sdk.a.a.f f65518d;

        public boolean a(String str) {
            if (this.f65515a.startsWith(CertificatePinner.Pin.WILDCARD)) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f65516b.length()) {
                    String str2 = this.f65516b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f65516b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f65515a.equals(bVar.f65515a) && this.f65517c.equals(bVar.f65517c) && this.f65518d.equals(bVar.f65518d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f65515a.hashCode()) * 31) + this.f65517c.hashCode()) * 31) + this.f65518d.hashCode();
        }

        public String toString() {
            return this.f65517c + this.f65518d.b();
        }
    }

    public k(Set<b> set, d.b.c.a.b.a.k.c cVar) {
        this.f65512a = set;
        this.f65513b = cVar;
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

    public k b(d.b.c.a.b.a.k.c cVar) {
        return d.b.c.a.b.a.e.u(this.f65513b, cVar) ? this : new k(this.f65512a, cVar);
    }

    public List<b> d(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f65512a) {
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
        d.b.c.a.b.a.k.c cVar = this.f65513b;
        if (cVar != null) {
            list = cVar.b(list, str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            int size2 = d2.size();
            com.bytedance.sdk.a.a.f fVar = null;
            com.bytedance.sdk.a.a.f fVar2 = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = d2.get(i3);
                if (bVar.f65517c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = f(x509Certificate);
                    }
                    if (bVar.f65518d.equals(fVar)) {
                        return;
                    }
                } else if (bVar.f65517c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f65518d.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f65517c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = d2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            sb.append("\n    ");
            sb.append(d2.get(i5));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (d.b.c.a.b.a.e.u(this.f65513b, kVar.f65513b) && this.f65512a.equals(kVar.f65512a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        d.b.c.a.b.a.k.c cVar = this.f65513b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f65512a.hashCode();
    }
}
