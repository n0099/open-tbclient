package d.b.c.a.b;

import com.bytedance.sdk.a.b.ad;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes6.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final ad f69342a;

    /* renamed from: b  reason: collision with root package name */
    public final l f69343b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f69344c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f69345d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f69342a = adVar;
        this.f69343b = lVar;
        this.f69344c = list;
        this.f69345d = list2;
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
                    emptyList = d.b.c.a.b.a.e.n(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = d.b.c.a.b.a.e.n(localCertificates);
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
        return this.f69343b;
    }

    public List<Certificate> c() {
        return this.f69344c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f69342a.equals(uVar.f69342a) && this.f69343b.equals(uVar.f69343b) && this.f69344c.equals(uVar.f69344c) && this.f69345d.equals(uVar.f69345d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f69342a.hashCode()) * 31) + this.f69343b.hashCode()) * 31) + this.f69344c.hashCode()) * 31) + this.f69345d.hashCode();
    }
}
