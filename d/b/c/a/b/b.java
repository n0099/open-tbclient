package d.b.c.a.b;

import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.s f65459a;

    /* renamed from: b  reason: collision with root package name */
    public final s f65460b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f65461c;

    /* renamed from: d  reason: collision with root package name */
    public final f f65462d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f65463e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f65464f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f65465g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f65466h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f65467i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i2, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i2);
        this.f65459a = aVar.l();
        if (sVar != null) {
            this.f65460b = sVar;
            if (socketFactory != null) {
                this.f65461c = socketFactory;
                if (fVar != null) {
                    this.f65462d = fVar;
                    if (list != null) {
                        this.f65463e = d.b.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f65464f = d.b.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f65465g = proxySelector;
                                this.f65466h = proxy;
                                this.f65467i = sSLSocketFactory;
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
        return this.f65459a;
    }

    public boolean b(b bVar) {
        return this.f65460b.equals(bVar.f65460b) && this.f65462d.equals(bVar.f65462d) && this.f65463e.equals(bVar.f65463e) && this.f65464f.equals(bVar.f65464f) && this.f65465g.equals(bVar.f65465g) && d.b.c.a.b.a.e.u(this.f65466h, bVar.f65466h) && d.b.c.a.b.a.e.u(this.f65467i, bVar.f65467i) && d.b.c.a.b.a.e.u(this.j, bVar.j) && d.b.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f65460b;
    }

    public SocketFactory d() {
        return this.f65461c;
    }

    public f e() {
        return this.f65462d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f65459a.equals(bVar.f65459a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f65463e;
    }

    public List<o> g() {
        return this.f65464f;
    }

    public ProxySelector h() {
        return this.f65465g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f65459a.hashCode()) * 31) + this.f65460b.hashCode()) * 31) + this.f65462d.hashCode()) * 31) + this.f65463e.hashCode()) * 31) + this.f65464f.hashCode()) * 31) + this.f65465g.hashCode()) * 31;
        Proxy proxy = this.f65466h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f65467i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f65466h;
    }

    public SSLSocketFactory j() {
        return this.f65467i;
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
        sb.append(this.f65459a.v());
        sb.append(":");
        sb.append(this.f65459a.w());
        if (this.f65466h != null) {
            sb.append(", proxy=");
            sb.append(this.f65466h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f65465g);
        }
        sb.append("}");
        return sb.toString();
    }
}
