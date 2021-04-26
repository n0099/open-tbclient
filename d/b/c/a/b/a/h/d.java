package d.b.c.a.b.a.h;

import android.net.http.Headers;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.b.c.a.a.p;
import d.b.c.a.a.q;
import d.b.c.a.b.a.e;
import d.b.c.a.b.a0;
import d.b.c.a.b.c;
import d.b.c.a.b.v;
import d.b.c.a.b.w;
import d.b.c.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class d implements e.InterfaceC1758e {

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f64614f = com.bytedance.sdk.a.a.f.a("connection");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f64615g = com.bytedance.sdk.a.a.f.a("host");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f64616h = com.bytedance.sdk.a.a.f.a("keep-alive");

    /* renamed from: i  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f64617i = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    public static final com.bytedance.sdk.a.a.f j = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    public static final com.bytedance.sdk.a.a.f k = com.bytedance.sdk.a.a.f.a("te");
    public static final com.bytedance.sdk.a.a.f l = com.bytedance.sdk.a.a.f.a("encoding");
    public static final com.bytedance.sdk.a.a.f m;
    public static final List<com.bytedance.sdk.a.a.f> n;
    public static final List<com.bytedance.sdk.a.a.f> o;

    /* renamed from: a  reason: collision with root package name */
    public final y f64618a;

    /* renamed from: b  reason: collision with root package name */
    public final w.a f64619b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.c.a.b.a.c.f f64620c;

    /* renamed from: d  reason: collision with root package name */
    public final e f64621d;

    /* renamed from: e  reason: collision with root package name */
    public g f64622e;

    /* loaded from: classes5.dex */
    public class a extends d.b.c.a.a.g {

        /* renamed from: f  reason: collision with root package name */
        public boolean f64623f;

        /* renamed from: g  reason: collision with root package name */
        public long f64624g;

        public a(q qVar) {
            super(qVar);
            this.f64623f = false;
            this.f64624g = 0L;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = n().a(cVar, j);
                if (a2 > 0) {
                    this.f64624g += a2;
                }
                return a2;
            } catch (IOException e2) {
                o(e2);
                throw e2;
            }
        }

        @Override // d.b.c.a.a.g, d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            o(null);
        }

        public final void o(IOException iOException) {
            if (this.f64623f) {
                return;
            }
            this.f64623f = true;
            d dVar = d.this;
            dVar.f64620c.i(false, dVar, this.f64624g, iOException);
        }
    }

    static {
        com.bytedance.sdk.a.a.f a2 = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        m = a2;
        n = d.b.c.a.b.a.e.n(f64614f, f64615g, f64616h, f64617i, k, j, l, a2, d.b.c.a.b.a.h.a.f64584f, d.b.c.a.b.a.h.a.f64585g, d.b.c.a.b.a.h.a.f64586h, d.b.c.a.b.a.h.a.f64587i);
        o = d.b.c.a.b.a.e.n(f64614f, f64615g, f64616h, f64617i, k, j, l, m);
    }

    public d(y yVar, w.a aVar, d.b.c.a.b.a.c.f fVar, e eVar) {
        this.f64618a = yVar;
        this.f64619b = aVar;
        this.f64620c = fVar;
        this.f64621d = eVar;
    }

    public static c.a d(List<d.b.c.a.b.a.h.a> list) throws IOException {
        v.a aVar = new v.a();
        int size = list.size();
        e.m mVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            d.b.c.a.b.a.h.a aVar2 = list.get(i2);
            if (aVar2 == null) {
                if (mVar != null && mVar.f64560b == 100) {
                    aVar = new v.a();
                    mVar = null;
                }
            } else {
                com.bytedance.sdk.a.a.f fVar = aVar2.f64588a;
                String a2 = aVar2.f64589b.a();
                if (fVar.equals(d.b.c.a.b.a.h.a.f64583e)) {
                    mVar = e.m.b("HTTP/1.1 " + a2);
                } else if (!o.contains(fVar)) {
                    d.b.c.a.b.a.b.f64489a.g(aVar, fVar.a(), a2);
                }
            }
        }
        if (mVar != null) {
            c.a aVar3 = new c.a();
            aVar3.g(com.bytedance.sdk.a.b.w.HTTP_2);
            aVar3.a(mVar.f64560b);
            aVar3.i(mVar.f64561c);
            aVar3.f(aVar.c());
            return aVar3;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<d.b.c.a.b.a.h.a> e(a0 a0Var) {
        v d2 = a0Var.d();
        ArrayList arrayList = new ArrayList(d2.a() + 4);
        arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f64584f, a0Var.c()));
        arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f64585g, e.k.a(a0Var.a())));
        String b2 = a0Var.b("Host");
        if (b2 != null) {
            arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f64587i, b2));
        }
        arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f64586h, a0Var.a().m()));
        int a2 = d2.a();
        for (int i2 = 0; i2 < a2; i2++) {
            com.bytedance.sdk.a.a.f a3 = com.bytedance.sdk.a.a.f.a(d2.b(i2).toLowerCase(Locale.US));
            if (!n.contains(a3)) {
                arrayList.add(new d.b.c.a.b.a.h.a(a3, d2.e(i2)));
            }
        }
        return arrayList;
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1758e
    public void a(a0 a0Var) throws IOException {
        if (this.f64622e != null) {
            return;
        }
        g p = this.f64621d.p(e(a0Var), a0Var.e() != null);
        this.f64622e = p;
        p.l().b(this.f64619b.c(), TimeUnit.MILLISECONDS);
        this.f64622e.m().b(this.f64619b.d(), TimeUnit.MILLISECONDS);
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1758e
    public void b() throws IOException {
        this.f64622e.o().close();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1758e
    public p c(a0 a0Var, long j2) {
        return this.f64622e.o();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1758e
    public d.b.c.a.b.d b(d.b.c.a.b.c cVar) throws IOException {
        d.b.c.a.b.a.c.f fVar = this.f64620c;
        fVar.f64519f.t(fVar.f64518e);
        return new e.j(cVar.o("Content-Type"), e.g.c(cVar), d.b.c.a.a.k.b(new a(this.f64622e.n())));
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1758e
    public void a() throws IOException {
        this.f64621d.C();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1758e
    public c.a a(boolean z) throws IOException {
        c.a d2 = d(this.f64622e.j());
        if (z && d.b.c.a.b.a.b.f64489a.a(d2) == 100) {
            return null;
        }
        return d2;
    }
}
