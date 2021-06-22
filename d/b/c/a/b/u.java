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
    public final ad f69446a;

    /* renamed from: b  reason: collision with root package name */
    public final l f69447b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f69448c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f69449d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f69446a = adVar;
        this.f69447b = lVar;
        this.f69448c = list;
        this.f69449d = list2;
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
        return this.f69447b;
    }

    public List<Certificate> c() {
        return this.f69448c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f69446a.equals(uVar.f69446a) && this.f69447b.equals(uVar.f69447b) && this.f69448c.equals(uVar.f69448c) && this.f69449d.equals(uVar.f69449d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f69446a.hashCode()) * 31) + this.f69447b.hashCode()) * 31) + this.f69448c.hashCode()) * 31) + this.f69449d.hashCode();
    }
}
