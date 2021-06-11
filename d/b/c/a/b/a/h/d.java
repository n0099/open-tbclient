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
/* loaded from: classes6.dex */
public final class d implements e.InterfaceC1885e {

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69074f = com.bytedance.sdk.a.a.f.a("connection");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69075g = com.bytedance.sdk.a.a.f.a("host");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69076h = com.bytedance.sdk.a.a.f.a("keep-alive");

    /* renamed from: i  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69077i = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    public static final com.bytedance.sdk.a.a.f j = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    public static final com.bytedance.sdk.a.a.f k = com.bytedance.sdk.a.a.f.a("te");
    public static final com.bytedance.sdk.a.a.f l = com.bytedance.sdk.a.a.f.a("encoding");
    public static final com.bytedance.sdk.a.a.f m;
    public static final List<com.bytedance.sdk.a.a.f> n;
    public static final List<com.bytedance.sdk.a.a.f> o;

    /* renamed from: a  reason: collision with root package name */
    public final y f69078a;

    /* renamed from: b  reason: collision with root package name */
    public final w.a f69079b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.c.a.b.a.c.f f69080c;

    /* renamed from: d  reason: collision with root package name */
    public final e f69081d;

    /* renamed from: e  reason: collision with root package name */
    public g f69082e;

    /* loaded from: classes6.dex */
    public class a extends d.b.c.a.a.g {

        /* renamed from: f  reason: collision with root package name */
        public boolean f69083f;

        /* renamed from: g  reason: collision with root package name */
        public long f69084g;

        public a(q qVar) {
            super(qVar);
            this.f69083f = false;
            this.f69084g = 0L;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = n().a(cVar, j);
                if (a2 > 0) {
                    this.f69084g += a2;
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
            if (this.f69083f) {
                return;
            }
            this.f69083f = true;
            d dVar = d.this;
            dVar.f69080c.i(false, dVar, this.f69084g, iOException);
        }
    }

    static {
        com.bytedance.sdk.a.a.f a2 = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        m = a2;
        n = d.b.c.a.b.a.e.n(f69074f, f69075g, f69076h, f69077i, k, j, l, a2, d.b.c.a.b.a.h.a.f69044f, d.b.c.a.b.a.h.a.f69045g, d.b.c.a.b.a.h.a.f69046h, d.b.c.a.b.a.h.a.f69047i);
        o = d.b.c.a.b.a.e.n(f69074f, f69075g, f69076h, f69077i, k, j, l, m);
    }

    public d(y yVar, w.a aVar, d.b.c.a.b.a.c.f fVar, e eVar) {
        this.f69078a = yVar;
        this.f69079b = aVar;
        this.f69080c = fVar;
        this.f69081d = eVar;
    }

    public static c.a d(List<d.b.c.a.b.a.h.a> list) throws IOException {
        v.a aVar = new v.a();
        int size = list.size();
        e.m mVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            d.b.c.a.b.a.h.a aVar2 = list.get(i2);
            if (aVar2 == null) {
                if (mVar != null && mVar.f69020b == 100) {
                    aVar = new v.a();
                    mVar = null;
                }
            } else {
                com.bytedance.sdk.a.a.f fVar = aVar2.f69048a;
                String a2 = aVar2.f69049b.a();
                if (fVar.equals(d.b.c.a.b.a.h.a.f69043e)) {
                    mVar = e.m.b("HTTP/1.1 " + a2);
                } else if (!o.contains(fVar)) {
                    d.b.c.a.b.a.b.f68949a.g(aVar, fVar.a(), a2);
                }
            }
        }
        if (mVar != null) {
            c.a aVar3 = new c.a();
            aVar3.g(com.bytedance.sdk.a.b.w.HTTP_2);
            aVar3.a(mVar.f69020b);
            aVar3.i(mVar.f69021c);
            aVar3.f(aVar.c());
            return aVar3;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<d.b.c.a.b.a.h.a> e(a0 a0Var) {
        v d2 = a0Var.d();
        ArrayList arrayList = new ArrayList(d2.a() + 4);
        arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f69044f, a0Var.c()));
        arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f69045g, e.k.a(a0Var.a())));
        String b2 = a0Var.b("Host");
        if (b2 != null) {
            arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f69047i, b2));
        }
        arrayList.add(new d.b.c.a.b.a.h.a(d.b.c.a.b.a.h.a.f69046h, a0Var.a().m()));
        int a2 = d2.a();
        for (int i2 = 0; i2 < a2; i2++) {
            com.bytedance.sdk.a.a.f a3 = com.bytedance.sdk.a.a.f.a(d2.b(i2).toLowerCase(Locale.US));
            if (!n.contains(a3)) {
                arrayList.add(new d.b.c.a.b.a.h.a(a3, d2.e(i2)));
            }
        }
        return arrayList;
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1885e
    public void a(a0 a0Var) throws IOException {
        if (this.f69082e != null) {
            return;
        }
        g p = this.f69081d.p(e(a0Var), a0Var.e() != null);
        this.f69082e = p;
        p.l().b(this.f69079b.c(), TimeUnit.MILLISECONDS);
        this.f69082e.m().b(this.f69079b.d(), TimeUnit.MILLISECONDS);
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1885e
    public void b() throws IOException {
        this.f69082e.o().close();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1885e
    public p c(a0 a0Var, long j2) {
        return this.f69082e.o();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1885e
    public d.b.c.a.b.d b(d.b.c.a.b.c cVar) throws IOException {
        d.b.c.a.b.a.c.f fVar = this.f69080c;
        fVar.f68979f.t(fVar.f68978e);
        return new e.j(cVar.o("Content-Type"), e.g.c(cVar), d.b.c.a.a.k.b(new a(this.f69082e.n())));
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1885e
    public void a() throws IOException {
        this.f69081d.C();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1885e
    public c.a a(boolean z) throws IOException {
        c.a d2 = d(this.f69082e.j());
        if (z && d.b.c.a.b.a.b.f68949a.a(d2) == 100) {
            return null;
        }
        return d2;
    }
}
