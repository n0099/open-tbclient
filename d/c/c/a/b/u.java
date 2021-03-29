package d.c.c.a.b;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.bytedance.sdk.a.b.ad;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final ad f65551a;

    /* renamed from: b  reason: collision with root package name */
    public final l f65552b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f65553c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f65554d;

    public u(ad adVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f65551a = adVar;
        this.f65552b = lVar;
        this.f65553c = list;
        this.f65554d = list2;
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
        return this.f65552b;
    }

    public List<Certificate> c() {
        return this.f65553c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f65551a.equals(uVar.f65551a) && this.f65552b.equals(uVar.f65552b) && this.f65553c.equals(uVar.f65553c) && this.f65554d.equals(uVar.f65554d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.f65551a.hashCode()) * 31) + this.f65552b.hashCode()) * 31) + this.f65553c.hashCode()) * 31) + this.f65554d.hashCode();
    }
}
