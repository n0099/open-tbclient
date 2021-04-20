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
    public final ad f66396a;

    /* renamed from: b  reason: collision with root package name */
    public final l f66397b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f66398c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f66399d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f66396a = adVar;
        this.f66397b = lVar;
        this.f66398c = list;
        this.f66399d = list2;
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
        return this.f66397b;
    }

    public List<Certificate> c() {
        return this.f66398c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f66396a.equals(uVar.f66396a) && this.f66397b.equals(uVar.f66397b) && this.f66398c.equals(uVar.f66398c) && this.f66399d.equals(uVar.f66399d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f66396a.hashCode()) * 31) + this.f66397b.hashCode()) * 31) + this.f66398c.hashCode()) * 31) + this.f66399d.hashCode();
    }
}
