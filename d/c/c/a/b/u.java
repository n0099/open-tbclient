package d.c.c.a.b;

import com.bytedance.sdk.a.b.ad;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final ad f66491a;

    /* renamed from: b  reason: collision with root package name */
    public final l f66492b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f66493c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f66494d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f66491a = adVar;
        this.f66492b = lVar;
        this.f66493c = list;
        this.f66494d = list2;
    }

    public static u b(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            l a2 = l.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                ad a3 = ad.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    emptyList = d.c.c.a.b.a.e.n(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = d.c.c.a.b.a.e.n(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new u(a3, a2, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public l a() {
        return this.f66492b;
    }

    public List<Certificate> c() {
        return this.f66493c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f66491a.equals(uVar.f66491a) && this.f66492b.equals(uVar.f66492b) && this.f66493c.equals(uVar.f66493c) && this.f66494d.equals(uVar.f66494d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f66491a.hashCode()) * 31) + this.f66492b.hashCode()) * 31) + this.f66493c.hashCode()) * 31) + this.f66494d.hashCode();
    }
}
