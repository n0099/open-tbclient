package d.c.c.a.b;

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
    public final com.bytedance.sdk.a.b.s f66388a;

    /* renamed from: b  reason: collision with root package name */
    public final s f66389b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f66390c;

    /* renamed from: d  reason: collision with root package name */
    public final f f66391d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f66392e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f66393f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f66394g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f66395h;
    public final SSLSocketFactory i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i);
        this.f66388a = aVar.l();
        if (sVar != null) {
            this.f66389b = sVar;
            if (socketFactory != null) {
                this.f66390c = socketFactory;
                if (fVar != null) {
                    this.f66391d = fVar;
                    if (list != null) {
                        this.f66392e = d.c.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f66393f = d.c.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f66394g = proxySelector;
                                this.f66395h = proxy;
                                this.i = sSLSocketFactory;
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
        return this.f66388a;
    }

    public boolean b(b bVar) {
        return this.f66389b.equals(bVar.f66389b) && this.f66391d.equals(bVar.f66391d) && this.f66392e.equals(bVar.f66392e) && this.f66393f.equals(bVar.f66393f) && this.f66394g.equals(bVar.f66394g) && d.c.c.a.b.a.e.u(this.f66395h, bVar.f66395h) && d.c.c.a.b.a.e.u(this.i, bVar.i) && d.c.c.a.b.a.e.u(this.j, bVar.j) && d.c.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f66389b;
    }

    public SocketFactory d() {
        return this.f66390c;
    }

    public f e() {
        return this.f66391d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f66388a.equals(bVar.f66388a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f66392e;
    }

    public List<o> g() {
        return this.f66393f;
    }

    public ProxySelector h() {
        return this.f66394g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f66388a.hashCode()) * 31) + this.f66389b.hashCode()) * 31) + this.f66391d.hashCode()) * 31) + this.f66392e.hashCode()) * 31) + this.f66393f.hashCode()) * 31) + this.f66394g.hashCode()) * 31;
        Proxy proxy = this.f66395h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f66395h;
    }

    public SSLSocketFactory j() {
        return this.i;
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
        sb.append(this.f66388a.v());
        sb.append(":");
        sb.append(this.f66388a.w());
        if (this.f66395h != null) {
            sb.append(", proxy=");
            sb.append(this.f66395h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f66394g);
        }
        sb.append("}");
        return sb.toString();
    }
}
