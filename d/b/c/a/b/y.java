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
/* loaded from: classes5.dex */
public class y implements Cloneable {
    public static final List<com.bytedance.sdk.a.b.w> F = d.b.c.a.b.a.e.n(com.bytedance.sdk.a.b.w.HTTP_2, com.bytedance.sdk.a.b.w.HTTP_1_1);
    public static final List<o> G = d.b.c.a.b.a.e.n(o.f64852f, o.f64853g);
    public final boolean A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;

    /* renamed from: e  reason: collision with root package name */
    public final r f64892e;

    /* renamed from: f  reason: collision with root package name */
    public final Proxy f64893f;

    /* renamed from: g  reason: collision with root package name */
    public final List<com.bytedance.sdk.a.b.w> f64894g;

    /* renamed from: h  reason: collision with root package name */
    public final List<o> f64895h;

    /* renamed from: i  reason: collision with root package name */
    public final List<w> f64896i;
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

    /* loaded from: classes5.dex */
    public static class a extends d.b.c.a.b.a.b {
        @Override // d.b.c.a.b.a.b
        public int a(c.a aVar) {
            return aVar.f64793c;
        }

        @Override // d.b.c.a.b.a.b
        public d.b.c.a.b.a.c.c b(n nVar, d.b.c.a.b.b bVar, d.b.c.a.b.a.c.f fVar, e eVar) {
            return nVar.c(bVar, fVar, eVar);
        }

        @Override // d.b.c.a.b.a.b
        public d.b.c.a.b.a.c.d c(n nVar) {
            return nVar.f64848e;
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
        d.b.c.a.b.a.b.f64489a = new a();
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
        return this.f64893f;
    }

    public ProxySelector h() {
        return this.l;
    }

    public q i() {
        return this.m;
    }

    public d.b.c.a.b.a.a.d j() {
        g gVar = this.n;
        return gVar != null ? gVar.f64807e : this.o;
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
        return this.f64892e;
    }

    public List<com.bytedance.sdk.a.b.w> w() {
        return this.f64894g;
    }

    public List<o> x() {
        return this.f64895h;
    }

    public List<w> y() {
        return this.f64896i;
    }

    public List<w> z() {
        return this.j;
    }

    public y(b bVar) {
        boolean z;
        this.f64892e = bVar.f64897a;
        this.f64893f = bVar.f64898b;
        this.f64894g = bVar.f64899c;
        this.f64895h = bVar.f64900d;
        this.f64896i = d.b.c.a.b.a.e.m(bVar.f64901e);
        this.j = d.b.c.a.b.a.e.m(bVar.f64902f);
        this.k = bVar.f64903g;
        this.l = bVar.f64904h;
        this.m = bVar.f64905i;
        this.n = bVar.j;
        this.o = bVar.k;
        this.p = bVar.l;
        loop0: while (true) {
            for (o oVar : this.f64895h) {
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
        if (!this.f64896i.contains(null)) {
            if (this.j.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.j);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f64896i);
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public int A;

        /* renamed from: a  reason: collision with root package name */
        public r f64897a;

        /* renamed from: b  reason: collision with root package name */
        public Proxy f64898b;

        /* renamed from: c  reason: collision with root package name */
        public List<com.bytedance.sdk.a.b.w> f64899c;

        /* renamed from: d  reason: collision with root package name */
        public List<o> f64900d;

        /* renamed from: e  reason: collision with root package name */
        public final List<w> f64901e;

        /* renamed from: f  reason: collision with root package name */
        public final List<w> f64902f;

        /* renamed from: g  reason: collision with root package name */
        public t.c f64903g;

        /* renamed from: h  reason: collision with root package name */
        public ProxySelector f64904h;

        /* renamed from: i  reason: collision with root package name */
        public q f64905i;
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
            this.f64901e = new ArrayList();
            this.f64902f = new ArrayList();
            this.f64897a = new r();
            this.f64899c = y.F;
            this.f64900d = y.G;
            this.f64903g = t.a(t.f64880a);
            this.f64904h = ProxySelector.getDefault();
            this.f64905i = q.f64871a;
            this.l = SocketFactory.getDefault();
            this.o = d.b.c.a.b.a.k.e.f64761a;
            this.p = k.f64825c;
            f fVar = f.f64806a;
            this.q = fVar;
            this.r = fVar;
            this.s = new n();
            this.t = s.f64879a;
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
            this.f64901e = new ArrayList();
            this.f64902f = new ArrayList();
            this.f64897a = yVar.f64892e;
            this.f64898b = yVar.f64893f;
            this.f64899c = yVar.f64894g;
            this.f64900d = yVar.f64895h;
            this.f64901e.addAll(yVar.f64896i);
            this.f64902f.addAll(yVar.j);
            this.f64903g = yVar.k;
            this.f64904h = yVar.l;
            this.f64905i = yVar.m;
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
