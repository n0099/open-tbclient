package d.b.c.a.b;

import d.b.c.a.b.c;
import d.b.c.a.b.t;
import d.b.c.a.b.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes6.dex */
public class y implements Cloneable {
    public static final List<com.bytedance.sdk.a.b.w> F = d.b.c.a.b.a.e.n(com.bytedance.sdk.a.b.w.HTTP_2, com.bytedance.sdk.a.b.w.HTTP_1_1);
    public static final List<o> G = d.b.c.a.b.a.e.n(o.f69312f, o.f69313g);
    public final boolean A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;

    /* renamed from: e  reason: collision with root package name */
    public final r f69352e;

    /* renamed from: f  reason: collision with root package name */
    public final Proxy f69353f;

    /* renamed from: g  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f69354g;

    /* renamed from: h  reason: collision with root package name */
    public final List<o> f69355h;

    /* renamed from: i  reason: collision with root package name */
    public final List<w> f69356i;
    public final List<w> j;
    public final t.c k;
    public final ProxySelector l;
    public final q m;
    public final g n;
    public final d.b.c.a.b.a.a.d o;
    public final SocketFactory p;
    public final SSLSocketFactory q;
    public final d.b.c.a.b.a.k.c r;
    public final HostnameVerifier s;
    public final k t;
    public final f u;
    public final f v;
    public final n w;
    public final s x;
    public final boolean y;
    public final boolean z;

    /* loaded from: classes6.dex */
    public static class a extends d.b.c.a.b.a.b {
        @Override // d.b.c.a.b.a.b
        public int a(c.a aVar) {
            return aVar.f69253c;
        }

        @Override // d.b.c.a.b.a.b
        public d.b.c.a.b.a.c.c b(n nVar, d.b.c.a.b.b bVar, d.b.c.a.b.a.c.f fVar, e eVar) {
            return nVar.c(bVar, fVar, eVar);
        }

        @Override // d.b.c.a.b.a.b
        public d.b.c.a.b.a.c.d c(n nVar) {
            return nVar.f69308e;
        }

        @Override // d.b.c.a.b.a.b
        public Socket d(n nVar, d.b.c.a.b.b bVar, d.b.c.a.b.a.c.f fVar) {
            return nVar.d(bVar, fVar);
        }

        @Override // d.b.c.a.b.a.b
        public void e(o oVar, SSLSocket sSLSocket, boolean z) {
            oVar.a(sSLSocket, z);
        }

        @Override // d.b.c.a.b.a.b
        public void f(v.a aVar, String str) {
            aVar.a(str);
        }

        @Override // d.b.c.a.b.a.b
        public void g(v.a aVar, String str, String str2) {
            aVar.e(str, str2);
        }

        @Override // d.b.c.a.b.a.b
        public boolean h(d.b.c.a.b.b bVar, d.b.c.a.b.b bVar2) {
            return bVar.b(bVar2);
        }

        @Override // d.b.c.a.b.a.b
        public boolean i(n nVar, d.b.c.a.b.a.c.c cVar) {
            return nVar.f(cVar);
        }

        @Override // d.b.c.a.b.a.b
        public void j(n nVar, d.b.c.a.b.a.c.c cVar) {
            nVar.e(cVar);
        }
    }

    static {
        d.b.c.a.b.a.b.f68949a = new a();
    }

    public y() {
        this(new b());
    }

    public t.c A() {
        return this.k;
    }

    public b B() {
        return new b(this);
    }

    public final X509TrustManager C() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw d.b.c.a.b.a.e.g("No System TLS", e2);
        }
    }

    public int b() {
        return this.B;
    }

    public i c(a0 a0Var) {
        return z.c(this, a0Var, false);
    }

    public final SSLSocketFactory d(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw d.b.c.a.b.a.e.g("No System TLS", e2);
        }
    }

    public int e() {
        return this.C;
    }

    public int f() {
        return this.D;
    }

    public Proxy g() {
        return this.f69353f;
    }

    public ProxySelector h() {
        return this.l;
    }

    public q i() {
        return this.m;
    }

    public d.b.c.a.b.a.a.d j() {
        g gVar = this.n;
        return gVar != null ? gVar.f69267e : this.o;
    }

    public s k() {
        return this.x;
    }

    public SocketFactory l() {
        return this.p;
    }

    public SSLSocketFactory m() {
        return this.q;
    }

    public HostnameVerifier n() {
        return this.s;
    }

    public k o() {
        return this.t;
    }

    public f p() {
        return this.v;
    }

    public f q() {
        return this.u;
    }

    public n r() {
        return this.w;
    }

    public boolean s() {
        return this.y;
    }

    public boolean t() {
        return this.z;
    }

    public boolean u() {
        return this.A;
    }

    public r v() {
        return this.f69352e;
    }

    public List<com.bytedance.sdk.a.b.w> w() {
        return this.f69354g;
    }

    public List<o> x() {
        return this.f69355h;
    }

    public List<w> y() {
        return this.f69356i;
    }

    public List<w> z() {
        return this.j;
    }

    public y(b bVar) {
        boolean z;
        this.f69352e = bVar.f69357a;
        this.f69353f = bVar.f69358b;
        this.f69354g = bVar.f69359c;
        this.f69355h = bVar.f69360d;
        this.f69356i = d.b.c.a.b.a.e.m(bVar.f69361e);
        this.j = d.b.c.a.b.a.e.m(bVar.f69362f);
        this.k = bVar.f69363g;
        this.l = bVar.f69364h;
        this.m = bVar.f69365i;
        this.n = bVar.j;
        this.o = bVar.k;
        this.p = bVar.l;
        loop0: while (true) {
            for (o oVar : this.f69355h) {
                z = z || oVar.b();
            }
        }
        if (bVar.m == null && z) {
            X509TrustManager C = C();
            this.q = d(C);
            this.r = d.b.c.a.b.a.k.c.a(C);
        } else {
            this.q = bVar.m;
            this.r = bVar.n;
        }
        this.s = bVar.o;
        this.t = bVar.p.b(this.r);
        this.u = bVar.q;
        this.v = bVar.r;
        this.w = bVar.s;
        this.x = bVar.t;
        this.y = bVar.u;
        this.z = bVar.v;
        this.A = bVar.w;
        this.B = bVar.x;
        this.C = bVar.y;
        this.D = bVar.z;
        this.E = bVar.A;
        if (!this.f69356i.contains(null)) {
            if (this.j.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.j);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f69356i);
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public int A;

        /* renamed from: a  reason: collision with root package name */
        public r f69357a;

        /* renamed from: b  reason: collision with root package name */
        public Proxy f69358b;

        /* renamed from: c  reason: collision with root package name */
        public List<com.bytedance.sdk.a.b.w> f69359c;

        /* renamed from: d  reason: collision with root package name */
        public List<o> f69360d;

        /* renamed from: e  reason: collision with root package name */
        public final List<w> f69361e;

        /* renamed from: f  reason: collision with root package name */
        public final List<w> f69362f;

        /* renamed from: g  reason: collision with root package name */
        public t.c f69363g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f69364h;

        /* renamed from: i  reason: collision with root package name */
        public q f69365i;
        public g j;
        public d.b.c.a.b.a.a.d k;
        public SocketFactory l;
        public SSLSocketFactory m;
        public d.b.c.a.b.a.k.c n;
        public HostnameVerifier o;
        public k p;
        public f q;
        public f r;
        public n s;
        public s t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b() {
            this.f69361e = new ArrayList();
            this.f69362f = new ArrayList();
            this.f69357a = new r();
            this.f69359c = y.F;
            this.f69360d = y.G;
            this.f69363g = t.a(t.f69340a);
            this.f69364h = ProxySelector.getDefault();
            this.f69365i = q.f69331a;
            this.l = SocketFactory.getDefault();
            this.o = d.b.c.a.b.a.k.e.f69221a;
            this.p = k.f69285c;
            f fVar = f.f69266a;
            this.q = fVar;
            this.r = fVar;
            this.s = new n();
            this.t = s.f69339a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public b a(long j, TimeUnit timeUnit) {
            this.x = d.b.c.a.b.a.e.e("timeout", j, timeUnit);
            return this;
        }

        public b b(boolean z) {
            this.u = z;
            return this;
        }

        public y c() {
            return new y(this);
        }

        public b d(long j, TimeUnit timeUnit) {
            this.y = d.b.c.a.b.a.e.e("timeout", j, timeUnit);
            return this;
        }

        public b e(boolean z) {
            this.v = z;
            return this;
        }

        public b f(long j, TimeUnit timeUnit) {
            this.z = d.b.c.a.b.a.e.e("timeout", j, timeUnit);
            return this;
        }

        public b(y yVar) {
            this.f69361e = new ArrayList();
            this.f69362f = new ArrayList();
            this.f69357a = yVar.f69352e;
            this.f69358b = yVar.f69353f;
            this.f69359c = yVar.f69354g;
            this.f69360d = yVar.f69355h;
            this.f69361e.addAll(yVar.f69356i);
            this.f69362f.addAll(yVar.j);
            this.f69363g = yVar.k;
            this.f69364h = yVar.l;
            this.f69365i = yVar.m;
            this.k = yVar.o;
            this.j = yVar.n;
            this.l = yVar.p;
            this.m = yVar.q;
            this.n = yVar.r;
            this.o = yVar.s;
            this.p = yVar.t;
            this.q = yVar.u;
            this.r = yVar.v;
            this.s = yVar.w;
            this.t = yVar.x;
            this.u = yVar.y;
            this.v = yVar.z;
            this.w = yVar.A;
            this.x = yVar.B;
            this.y = yVar.C;
            this.z = yVar.D;
            this.A = yVar.E;
        }
    }
}
