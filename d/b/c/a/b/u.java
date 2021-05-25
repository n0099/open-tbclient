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
    public final ad f65611a;

    /* renamed from: b  reason: collision with root package name */
    public final l f65612b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f65613c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f65614d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f65611a = adVar;
        this.f65612b = lVar;
        this.f65613c = list;
        this.f65614d = list2;
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
        return this.f65612b;
    }

    public List<Certificate> c() {
        return this.f65613c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f65611a.equals(uVar.f65611a) && this.f65612b.equals(uVar.f65612b) && this.f65613c.equals(uVar.f65613c) && this.f65614d.equals(uVar.f65614d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f65611a.hashCode()) * 31) + this.f65612b.hashCode()) * 31) + this.f65613c.hashCode()) * 31) + this.f65614d.hashCode();
    }
}
