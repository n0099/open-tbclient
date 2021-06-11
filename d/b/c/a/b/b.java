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
    public final com.bytedance.sdk.a.b.s f69233a;

    /* renamed from: b  reason: collision with root package name */
    public final s f69234b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f69235c;

    /* renamed from: d  reason: collision with root package name */
    public final f f69236d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f69237e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f69238f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f69239g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f69240h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f69241i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i2, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i2);
        this.f69233a = aVar.l();
        if (sVar != null) {
            this.f69234b = sVar;
            if (socketFactory != null) {
                this.f69235c = socketFactory;
                if (fVar != null) {
                    this.f69236d = fVar;
                    if (list != null) {
                        this.f69237e = d.b.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f69238f = d.b.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f69239g = proxySelector;
                                this.f69240h = proxy;
                                this.f69241i = sSLSocketFactory;
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
        return this.f69233a;
    }

    public boolean b(b bVar) {
        return this.f69234b.equals(bVar.f69234b) && this.f69236d.equals(bVar.f69236d) && this.f69237e.equals(bVar.f69237e) && this.f69238f.equals(bVar.f69238f) && this.f69239g.equals(bVar.f69239g) && d.b.c.a.b.a.e.u(this.f69240h, bVar.f69240h) && d.b.c.a.b.a.e.u(this.f69241i, bVar.f69241i) && d.b.c.a.b.a.e.u(this.j, bVar.j) && d.b.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f69234b;
    }

    public SocketFactory d() {
        return this.f69235c;
    }

    public f e() {
        return this.f69236d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f69233a.equals(bVar.f69233a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f69237e;
    }

    public List<o> g() {
        return this.f69238f;
    }

    public ProxySelector h() {
        return this.f69239g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f69233a.hashCode()) * 31) + this.f69234b.hashCode()) * 31) + this.f69236d.hashCode()) * 31) + this.f69237e.hashCode()) * 31) + this.f69238f.hashCode()) * 31) + this.f69239g.hashCode()) * 31;
        Proxy proxy = this.f69240h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f69241i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f69240h;
    }

    public SSLSocketFactory j() {
        return this.f69241i;
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
        sb.append(this.f69233a.v());
        sb.append(":");
        sb.append(this.f69233a.w());
        if (this.f69240h != null) {
            sb.append(", proxy=");
            sb.append(this.f69240h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f69239g);
        }
        sb.append("}");
        return sb.toString();
    }
}
