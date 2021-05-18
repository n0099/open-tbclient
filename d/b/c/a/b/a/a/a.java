package d.b.c.a.b.a.a;

import d.b.c.a.a.k;
import d.b.c.a.a.p;
import d.b.c.a.a.q;
import d.b.c.a.a.r;
import d.b.c.a.b.a.a.c;
import d.b.c.a.b.a.e;
import d.b.c.a.b.a0;
import d.b.c.a.b.c;
import d.b.c.a.b.v;
import d.b.c.a.b.w;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    public final d f65159a;

    public a(d dVar) {
        this.f65159a = dVar;
    }

    public static d.b.c.a.b.c c(d.b.c.a.b.c cVar) {
        if (cVar == null || cVar.x() == null) {
            return cVar;
        }
        c.a y = cVar.y();
        y.d(null);
        return y.k();
    }

    public static v d(v vVar, v vVar2) {
        v.a aVar = new v.a();
        int a2 = vVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            String b2 = vVar.b(i2);
            String e2 = vVar.e(i2);
            if ((!"Warning".equalsIgnoreCase(b2) || !e2.startsWith("1")) && (!e(b2) || vVar2.c(b2) == null)) {
                d.b.c.a.b.a.b.f65175a.g(aVar, b2, e2);
            }
        }
        int a3 = vVar2.a();
        for (int i3 = 0; i3 < a3; i3++) {
            String b3 = vVar2.b(i3);
            if (!"Content-Length".equalsIgnoreCase(b3) && e(b3)) {
                d.b.c.a.b.a.b.f65175a.g(aVar, b3, vVar2.e(i3));
            }
        }
        return aVar.c();
    }

    public static boolean e(String str) {
        return (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // d.b.c.a.b.w
    public d.b.c.a.b.c a(w.a aVar) throws IOException {
        d dVar = this.f65159a;
        d.b.c.a.b.c a2 = dVar != null ? dVar.a(aVar.a()) : null;
        c a3 = new c.a(System.currentTimeMillis(), aVar.a(), a2).a();
        a0 a0Var = a3.f65164a;
        d.b.c.a.b.c cVar = a3.f65165b;
        d dVar2 = this.f65159a;
        if (dVar2 != null) {
            dVar2.c(a3);
        }
        if (a2 != null && cVar == null) {
            e.q(a2.x());
        }
        if (a0Var == null && cVar == null) {
            c.a aVar2 = new c.a();
            aVar2.h(aVar.a());
            aVar2.g(com.bytedance.sdk.a.b.w.HTTP_1_1);
            aVar2.a(504);
            aVar2.i("Unsatisfiable Request (only-if-cached)");
            aVar2.d(e.f65213c);
            aVar2.b(-1L);
            aVar2.m(System.currentTimeMillis());
            return aVar2.k();
        } else if (a0Var == null) {
            c.a y = cVar.y();
            y.n(c(cVar));
            return y.k();
        } else {
            try {
                d.b.c.a.b.c a4 = aVar.a(a0Var);
                if (a4 == null && a2 != null) {
                }
                if (cVar != null) {
                    if (a4.r() == 304) {
                        c.a y2 = cVar.y();
                        y2.f(d(cVar.w(), a4.w()));
                        y2.b(a4.B());
                        y2.m(a4.m());
                        y2.n(c(cVar));
                        y2.c(c(a4));
                        d.b.c.a.b.c k = y2.k();
                        a4.x().close();
                        this.f65159a.a();
                        this.f65159a.d(cVar, k);
                        return k;
                    }
                    e.q(cVar.x());
                }
                c.a y3 = a4.y();
                y3.n(c(cVar));
                y3.c(c(a4));
                d.b.c.a.b.c k2 = y3.k();
                if (this.f65159a != null) {
                    if (e.g.h(k2) && c.a(k2, a0Var)) {
                        return b(this.f65159a.b(k2), k2);
                    }
                    if (e.h.a(a0Var.c())) {
                        try {
                            this.f65159a.e(a0Var);
                        } catch (IOException unused) {
                        }
                    }
                }
                return k2;
            } finally {
                if (a2 != null) {
                    e.q(a2.x());
                }
            }
        }
    }

    public final d.b.c.a.b.c b(b bVar, d.b.c.a.b.c cVar) throws IOException {
        p a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return cVar;
        }
        C1821a c1821a = new C1821a(this, cVar.x().r(), bVar, k.a(a2));
        String o = cVar.o("Content-Type");
        long o2 = cVar.x().o();
        c.a y = cVar.y();
        y.d(new e.j(o, o2, k.b(c1821a)));
        return y.k();
    }

    /* renamed from: d.b.c.a.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1821a implements q {

        /* renamed from: e  reason: collision with root package name */
        public boolean f65160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.a.e f65161f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f65162g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.a.d f65163h;

        public C1821a(a aVar, d.b.c.a.a.e eVar, b bVar, d.b.c.a.a.d dVar) {
            this.f65161f = eVar;
            this.f65162g = bVar;
            this.f65163h = dVar;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = this.f65161f.a(cVar, j);
                if (a2 == -1) {
                    if (!this.f65160e) {
                        this.f65160e = true;
                        this.f65163h.close();
                    }
                    return -1L;
                }
                cVar.n(this.f65163h.c(), cVar.v() - a2, a2);
                this.f65163h.u();
                return a2;
            } catch (IOException e2) {
                if (!this.f65160e) {
                    this.f65160e = true;
                    this.f65162g.b();
                }
                throw e2;
            }
        }

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f65160e && !e.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f65160e = true;
                this.f65162g.b();
            }
            this.f65161f.close();
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return this.f65161f.a();
        }
    }
}
