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
    public final com.bytedance.sdk.a.b.s f66293a;

    /* renamed from: b  reason: collision with root package name */
    public final s f66294b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f66295c;

    /* renamed from: d  reason: collision with root package name */
    public final f f66296d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f66297e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f66298f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f66299g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f66300h;
    public final SSLSocketFactory i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i);
        this.f66293a = aVar.l();
        if (sVar != null) {
            this.f66294b = sVar;
            if (socketFactory != null) {
                this.f66295c = socketFactory;
                if (fVar != null) {
                    this.f66296d = fVar;
                    if (list != null) {
                        this.f66297e = d.c.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f66298f = d.c.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f66299g = proxySelector;
                                this.f66300h = proxy;
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
        return this.f66293a;
    }

    public boolean b(b bVar) {
        return this.f66294b.equals(bVar.f66294b) && this.f66296d.equals(bVar.f66296d) && this.f66297e.equals(bVar.f66297e) && this.f66298f.equals(bVar.f66298f) && this.f66299g.equals(bVar.f66299g) && d.c.c.a.b.a.e.u(this.f66300h, bVar.f66300h) && d.c.c.a.b.a.e.u(this.i, bVar.i) && d.c.c.a.b.a.e.u(this.j, bVar.j) && d.c.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f66294b;
    }

    public SocketFactory d() {
        return this.f66295c;
    }

    public f e() {
        return this.f66296d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f66293a.equals(bVar.f66293a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f66297e;
    }

    public List<o> g() {
        return this.f66298f;
    }

    public ProxySelector h() {
        return this.f66299g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f66293a.hashCode()) * 31) + this.f66294b.hashCode()) * 31) + this.f66296d.hashCode()) * 31) + this.f66297e.hashCode()) * 31) + this.f66298f.hashCode()) * 31) + this.f66299g.hashCode()) * 31;
        Proxy proxy = this.f66300h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f66300h;
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
        sb.append(this.f66293a.v());
        sb.append(":");
        sb.append(this.f66293a.w());
        if (this.f66300h != null) {
            sb.append(", proxy=");
            sb.append(this.f66300h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f66299g);
        }
        sb.append("}");
        return sb.toString();
    }
}
