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
    public final com.bytedance.sdk.a.b.s f69337a;

    /* renamed from: b  reason: collision with root package name */
    public final s f69338b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f69339c;

    /* renamed from: d  reason: collision with root package name */
    public final f f69340d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f69341e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f69342f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f69343g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f69344h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f69345i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i2, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i2);
        this.f69337a = aVar.l();
        if (sVar != null) {
            this.f69338b = sVar;
            if (socketFactory != null) {
                this.f69339c = socketFactory;
                if (fVar != null) {
                    this.f69340d = fVar;
                    if (list != null) {
                        this.f69341e = d.b.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f69342f = d.b.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f69343g = proxySelector;
                                this.f69344h = proxy;
                                this.f69345i = sSLSocketFactory;
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
        return this.f69337a;
    }

    public boolean b(b bVar) {
        return this.f69338b.equals(bVar.f69338b) && this.f69340d.equals(bVar.f69340d) && this.f69341e.equals(bVar.f69341e) && this.f69342f.equals(bVar.f69342f) && this.f69343g.equals(bVar.f69343g) && d.b.c.a.b.a.e.u(this.f69344h, bVar.f69344h) && d.b.c.a.b.a.e.u(this.f69345i, bVar.f69345i) && d.b.c.a.b.a.e.u(this.j, bVar.j) && d.b.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f69338b;
    }

    public SocketFactory d() {
        return this.f69339c;
    }

    public f e() {
        return this.f69340d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f69337a.equals(bVar.f69337a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f69341e;
    }

    public List<o> g() {
        return this.f69342f;
    }

    public ProxySelector h() {
        return this.f69343g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f69337a.hashCode()) * 31) + this.f69338b.hashCode()) * 31) + this.f69340d.hashCode()) * 31) + this.f69341e.hashCode()) * 31) + this.f69342f.hashCode()) * 31) + this.f69343g.hashCode()) * 31;
        Proxy proxy = this.f69344h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f69345i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f69344h;
    }

    public SSLSocketFactory j() {
        return this.f69345i;
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
        sb.append(this.f69337a.v());
        sb.append(":");
        sb.append(this.f69337a.w());
        if (this.f69344h != null) {
            sb.append(", proxy=");
            sb.append(this.f69344h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f69343g);
        }
        sb.append("}");
        return sb.toString();
    }
}
