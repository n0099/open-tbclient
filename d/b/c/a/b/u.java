package d.b.c.a.b;

import com.bytedance.sdk.a.b.ad;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final ad f64882a;

    /* renamed from: b  reason: collision with root package name */
    public final l f64883b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f64884c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f64885d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f64882a = adVar;
        this.f64883b = lVar;
        this.f64884c = list;
        this.f64885d = list2;
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
        return this.f64883b;
    }

    public List<Certificate> c() {
        return this.f64884c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f64882a.equals(uVar.f64882a) && this.f64883b.equals(uVar.f64883b) && this.f64884c.equals(uVar.f64884c) && this.f64885d.equals(uVar.f64885d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f64882a.hashCode()) * 31) + this.f64883b.hashCode()) * 31) + this.f64884c.hashCode()) * 31) + this.f64885d.hashCode();
    }
}
