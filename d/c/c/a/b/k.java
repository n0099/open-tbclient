package d.c.c.a.b;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
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
    public static final k f65496c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f65497a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.c.a.b.a.k.c f65498b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f65499a = new ArrayList();

        public k a() {
            return new k(new LinkedHashSet(this.f65499a), null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f65500a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65501b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65502c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bytedance.sdk.a.a.f f65503d;

        public boolean a(String str) {
            if (this.f65500a.startsWith(CertificatePinner.Pin.WILDCARD)) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f65501b.length()) {
                    String str2 = this.f65501b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f65501b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f65500a.equals(bVar.f65500a) && this.f65502c.equals(bVar.f65502c) && this.f65503d.equals(bVar.f65503d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.f65500a.hashCode()) * 31) + this.f65502c.hashCode()) * 31) + this.f65503d.hashCode();
        }

        public String toString() {
            return this.f65502c + this.f65503d.b();
        }
    }

    public k(Set<b> set, d.c.c.a.b.a.k.c cVar) {
        this.f65497a = set;
        this.f65498b = cVar;
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
        return d.c.c.a.b.a.e.u(this.f65498b, cVar) ? this : new k(this.f65497a, cVar);
    }

    public List<b> d(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f65497a) {
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
        d.c.c.a.b.a.k.c cVar = this.f65498b;
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
                if (bVar.f65502c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = f(x509Certificate);
                    }
                    if (bVar.f65503d.equals(fVar)) {
                        return;
                    }
                } else if (bVar.f65502c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f65503d.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f65502c);
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
            if (d.c.c.a.b.a.e.u(this.f65498b, kVar.f65498b) && this.f65497a.equals(kVar.f65497a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        d.c.c.a.b.a.k.c cVar = this.f65498b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f65497a.hashCode();
    }
}
