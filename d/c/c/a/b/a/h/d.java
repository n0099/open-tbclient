package d.c.c.a.b.a.h;

import android.net.http.Headers;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import d.c.c.a.a.p;
import d.c.c.a.a.q;
import d.c.c.a.b.a.e;
import d.c.c.a.b.a0;
import d.c.c.a.b.c;
import d.c.c.a.b.v;
import d.c.c.a.b.w;
import d.c.c.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class d implements e.InterfaceC1815e {

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66145f = com.bytedance.sdk.a.a.f.a("connection");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66146g = com.bytedance.sdk.a.a.f.a("host");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66147h = com.bytedance.sdk.a.a.f.a("keep-alive");
    public static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    public static final com.bytedance.sdk.a.a.f j = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    public static final com.bytedance.sdk.a.a.f k = com.bytedance.sdk.a.a.f.a("te");
    public static final com.bytedance.sdk.a.a.f l = com.bytedance.sdk.a.a.f.a("encoding");
    public static final com.bytedance.sdk.a.a.f m;
    public static final List<com.bytedance.sdk.a.a.f> n;
    public static final List<com.bytedance.sdk.a.a.f> o;

    /* renamed from: a  reason: collision with root package name */
    public final y f66148a;

    /* renamed from: b  reason: collision with root package name */
    public final w.a f66149b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.c.a.b.a.c.f f66150c;

    /* renamed from: d  reason: collision with root package name */
    public final e f66151d;

    /* renamed from: e  reason: collision with root package name */
    public g f66152e;

    /* loaded from: classes5.dex */
    public class a extends d.c.c.a.a.g {

        /* renamed from: f  reason: collision with root package name */
        public boolean f66153f;

        /* renamed from: g  reason: collision with root package name */
        public long f66154g;

        public a(q qVar) {
            super(qVar);
            this.f66153f = false;
            this.f66154g = 0L;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = n().a(cVar, j);
                if (a2 > 0) {
                    this.f66154g += a2;
                }
                return a2;
            } catch (IOException e2) {
                o(e2);
                throw e2;
            }
        }

        @Override // d.c.c.a.a.g, d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            o(null);
        }

        public final void o(IOException iOException) {
            if (this.f66153f) {
                return;
            }
            this.f66153f = true;
            d dVar = d.this;
            dVar.f66150c.i(false, dVar, this.f66154g, iOException);
        }
    }

    static {
        com.bytedance.sdk.a.a.f a2 = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        m = a2;
        n = d.c.c.a.b.a.e.n(f66145f, f66146g, f66147h, i, k, j, l, a2, d.c.c.a.b.a.h.a.f66117f, d.c.c.a.b.a.h.a.f66118g, d.c.c.a.b.a.h.a.f66119h, d.c.c.a.b.a.h.a.i);
        o = d.c.c.a.b.a.e.n(f66145f, f66146g, f66147h, i, k, j, l, m);
    }

    public d(y yVar, w.a aVar, d.c.c.a.b.a.c.f fVar, e eVar) {
        this.f66148a = yVar;
        this.f66149b = aVar;
        this.f66150c = fVar;
        this.f66151d = eVar;
    }

    public static c.a d(List<d.c.c.a.b.a.h.a> list) throws IOException {
        v.a aVar = new v.a();
        int size = list.size();
        e.m mVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            d.c.c.a.b.a.h.a aVar2 = list.get(i2);
            if (aVar2 == null) {
                if (mVar != null && mVar.f66096b == 100) {
                    aVar = new v.a();
                    mVar = null;
                }
            } else {
                com.bytedance.sdk.a.a.f fVar = aVar2.f66120a;
                String a2 = aVar2.f66121b.a();
                if (fVar.equals(d.c.c.a.b.a.h.a.f66116e)) {
                    mVar = e.m.b("HTTP/1.1 " + a2);
                } else if (!o.contains(fVar)) {
                    d.c.c.a.b.a.b.f66029a.g(aVar, fVar.a(), a2);
                }
            }
        }
        if (mVar != null) {
            c.a aVar3 = new c.a();
            aVar3.g(com.bytedance.sdk.a.b.w.HTTP_2);
            aVar3.a(mVar.f66096b);
            aVar3.i(mVar.f66097c);
            aVar3.f(aVar.c());
            return aVar3;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<d.c.c.a.b.a.h.a> e(a0 a0Var) {
        v d2 = a0Var.d();
        ArrayList arrayList = new ArrayList(d2.a() + 4);
        arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.f66117f, a0Var.c()));
        arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.f66118g, e.k.a(a0Var.a())));
        String b2 = a0Var.b("Host");
        if (b2 != null) {
            arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.i, b2));
        }
        arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.f66119h, a0Var.a().m()));
        int a2 = d2.a();
        for (int i2 = 0; i2 < a2; i2++) {
            com.bytedance.sdk.a.a.f a3 = com.bytedance.sdk.a.a.f.a(d2.b(i2).toLowerCase(Locale.US));
            if (!n.contains(a3)) {
                arrayList.add(new d.c.c.a.b.a.h.a(a3, d2.e(i2)));
            }
        }
        return arrayList;
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1815e
    public void a(a0 a0Var) throws IOException {
        if (this.f66152e != null) {
            return;
        }
        g p = this.f66151d.p(e(a0Var), a0Var.e() != null);
        this.f66152e = p;
        p.l().b(this.f66149b.c(), TimeUnit.MILLISECONDS);
        this.f66152e.m().b(this.f66149b.d(), TimeUnit.MILLISECONDS);
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1815e
    public void b() throws IOException {
        this.f66152e.o().close();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1815e
    public p c(a0 a0Var, long j2) {
        return this.f66152e.o();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1815e
    public d.c.c.a.b.d b(d.c.c.a.b.c cVar) throws IOException {
        d.c.c.a.b.a.c.f fVar = this.f66150c;
        fVar.f66058f.t(fVar.f66057e);
        return new e.j(cVar.o("Content-Type"), e.g.c(cVar), d.c.c.a.a.k.b(new a(this.f66152e.n())));
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1815e
    public void a() throws IOException {
        this.f66151d.C();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1815e
    public c.a a(boolean z) throws IOException {
        c.a d2 = d(this.f66152e.j());
        if (z && d.c.c.a.b.a.b.f66029a.a(d2) == 100) {
            return null;
        }
        return d2;
    }
}
