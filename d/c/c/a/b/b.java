package d.c.c.a.b;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
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
    public final com.bytedance.sdk.a.b.s f65447a;

    /* renamed from: b  reason: collision with root package name */
    public final s f65448b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f65449c;

    /* renamed from: d  reason: collision with root package name */
    public final f f65450d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f65451e;

    /* renamed from: f  reason: collision with root package name */
    public final List<o> f65452f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f65453g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f65454h;
    public final SSLSocketFactory i;
    public final HostnameVerifier j;
    public final k k;

    public b(String str, int i, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, k kVar, f fVar, Proxy proxy, List<com.bytedance.sdk.a.b.w> list, List<o> list2, ProxySelector proxySelector) {
        s.a aVar = new s.a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.n(str);
        aVar.c(i);
        this.f65447a = aVar.l();
        if (sVar != null) {
            this.f65448b = sVar;
            if (socketFactory != null) {
                this.f65449c = socketFactory;
                if (fVar != null) {
                    this.f65450d = fVar;
                    if (list != null) {
                        this.f65451e = d.c.c.a.b.a.e.m(list);
                        if (list2 != null) {
                            this.f65452f = d.c.c.a.b.a.e.m(list2);
                            if (proxySelector != null) {
                                this.f65453g = proxySelector;
                                this.f65454h = proxy;
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
        return this.f65447a;
    }

    public boolean b(b bVar) {
        return this.f65448b.equals(bVar.f65448b) && this.f65450d.equals(bVar.f65450d) && this.f65451e.equals(bVar.f65451e) && this.f65452f.equals(bVar.f65452f) && this.f65453g.equals(bVar.f65453g) && d.c.c.a.b.a.e.u(this.f65454h, bVar.f65454h) && d.c.c.a.b.a.e.u(this.i, bVar.i) && d.c.c.a.b.a.e.u(this.j, bVar.j) && d.c.c.a.b.a.e.u(this.k, bVar.k) && a().w() == bVar.a().w();
    }

    public s c() {
        return this.f65448b;
    }

    public SocketFactory d() {
        return this.f65449c;
    }

    public f e() {
        return this.f65450d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f65447a.equals(bVar.f65447a) && b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public List<com.bytedance.sdk.a.b.w> f() {
        return this.f65451e;
    }

    public List<o> g() {
        return this.f65452f;
    }

    public ProxySelector h() {
        return this.f65453g;
    }

    public int hashCode() {
        int hashCode = (((((((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.f65447a.hashCode()) * 31) + this.f65448b.hashCode()) * 31) + this.f65450d.hashCode()) * 31) + this.f65451e.hashCode()) * 31) + this.f65452f.hashCode()) * 31) + this.f65453g.hashCode()) * 31;
        Proxy proxy = this.f65454h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        k kVar = this.k;
        return hashCode4 + (kVar != null ? kVar.hashCode() : 0);
    }

    public Proxy i() {
        return this.f65454h;
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
        sb.append(this.f65447a.v());
        sb.append(":");
        sb.append(this.f65447a.w());
        if (this.f65454h != null) {
            sb.append(", proxy=");
            sb.append(this.f65454h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f65453g);
        }
        sb.append("}");
        return sb.toString();
    }
}
