package d.b.c.a.b;

import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.s f64773a;

    /* renamed from: b  reason: collision with root package name */
    public final s f64774b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f64775c;

    /* renamed from: d  reason: collision with root package name */
    public final f f64776d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f64777e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f64778f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f64779g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f64780h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f64781i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i2, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i2);
        this.f64773a = aVar.l();
        if (sVar != null) {
            this.f64774b = sVar;
            if (socketFactory != null) {
                this.f64775c = socketFactory;
                if (fVar != null) {
                    this.f64776d = fVar;
                    if (list != null) {
                        this.f64777e = d.b.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f64778f = d.b.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f64779g = proxySelector;
                                this.f64780h = proxy;
                                this.f64781i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = kVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public com.bytedance.sdk.a.b.s a() {
        return this.f64773a;
    }

    public boolean b(b bVar) {
        return this.f64774b.equals(bVar.f64774b) && this.f64776d.equals(bVar.f64776d) && this.f64777e.equals(bVar.f64777e) && this.f64778f.equals(bVar.f64778f) && this.f64779g.equals(bVar.f64779g) && d.b.c.a.b.a.e.u(this.f64780h, bVar.f64780h) && d.b.c.a.b.a.e.u(this.f64781i, bVar.f64781i) && d.b.c.a.b.a.e.u(this.j, bVar.j) && d.b.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f64774b;
    }

    public SocketFactory d() {
        return this.f64775c;
    }

    public f e() {
        return this.f64776d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f64773a.equals(bVar.f64773a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f64777e;
    }

    public List<o> g() {
        return this.f64778f;
    }

    public ProxySelector h() {
        return this.f64779g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f64773a.hashCode()) * 31) + this.f64774b.hashCode()) * 31) + this.f64776d.hashCode()) * 31) + this.f64777e.hashCode()) * 31) + this.f64778f.hashCode()) * 31) + this.f64779g.hashCode()) * 31;
        Proxy proxy = this.f64780h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f64781i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f64780h;
    }

    public SSLSocketFactory j() {
        return this.f64781i;
    }

    public HostnameVerifier k() {
        return this.j;
    }

    public k l() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f64773a.v());
        sb.append(":");
        sb.append(this.f64773a.w());
        if (this.f64780h != null) {
            sb.append(", proxy=");
            sb.append(this.f64780h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f64779g);
        }
        sb.append("}");
        return sb.toString();
    }
}
