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
public final class d implements e.InterfaceC1786e {

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65299f = com.bytedance.sdk.a.a.f.a("connection");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65300g = com.bytedance.sdk.a.a.f.a("host");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65301h = com.bytedance.sdk.a.a.f.a("keep-alive");
    public static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.a(Headers.PROXY_CONNECTION);
    public static final com.bytedance.sdk.a.a.f j = com.bytedance.sdk.a.a.f.a(Headers.TRANSFER_ENCODING);
    public static final com.bytedance.sdk.a.a.f k = com.bytedance.sdk.a.a.f.a("te");
    public static final com.bytedance.sdk.a.a.f l = com.bytedance.sdk.a.a.f.a("encoding");
    public static final com.bytedance.sdk.a.a.f m;
    public static final List<com.bytedance.sdk.a.a.f> n;
    public static final List<com.bytedance.sdk.a.a.f> o;

    /* renamed from: a  reason: collision with root package name */
    public final y f65302a;

    /* renamed from: b  reason: collision with root package name */
    public final w.a f65303b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.c.a.b.a.c.f f65304c;

    /* renamed from: d  reason: collision with root package name */
    public final e f65305d;

    /* renamed from: e  reason: collision with root package name */
    public g f65306e;

    /* loaded from: classes5.dex */
    public class a extends d.c.c.a.a.g {

        /* renamed from: f  reason: collision with root package name */
        public boolean f65307f;

        /* renamed from: g  reason: collision with root package name */
        public long f65308g;

        public a(q qVar) {
            super(qVar);
            this.f65307f = false;
            this.f65308g = 0L;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = n().a(cVar, j);
                if (a2 > 0) {
                    this.f65308g += a2;
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
            if (this.f65307f) {
                return;
            }
            this.f65307f = true;
            d dVar = d.this;
            dVar.f65304c.i(false, dVar, this.f65308g, iOException);
        }
    }

    static {
        com.bytedance.sdk.a.a.f a2 = com.bytedance.sdk.a.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        m = a2;
        n = d.c.c.a.b.a.e.n(f65299f, f65300g, f65301h, i, k, j, l, a2, d.c.c.a.b.a.h.a.f65271f, d.c.c.a.b.a.h.a.f65272g, d.c.c.a.b.a.h.a.f65273h, d.c.c.a.b.a.h.a.i);
        o = d.c.c.a.b.a.e.n(f65299f, f65300g, f65301h, i, k, j, l, m);
    }

    public d(y yVar, w.a aVar, d.c.c.a.b.a.c.f fVar, e eVar) {
        this.f65302a = yVar;
        this.f65303b = aVar;
        this.f65304c = fVar;
        this.f65305d = eVar;
    }

    public static c.a d(List<d.c.c.a.b.a.h.a> list) throws IOException {
        v.a aVar = new v.a();
        int size = list.size();
        e.m mVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            d.c.c.a.b.a.h.a aVar2 = list.get(i2);
            if (aVar2 == null) {
                if (mVar != null && mVar.f65250b == 100) {
                    aVar = new v.a();
                    mVar = null;
                }
            } else {
                com.bytedance.sdk.a.a.f fVar = aVar2.f65274a;
                String a2 = aVar2.f65275b.a();
                if (fVar.equals(d.c.c.a.b.a.h.a.f65270e)) {
                    mVar = e.m.b("HTTP/1.1 " + a2);
                } else if (!o.contains(fVar)) {
                    d.c.c.a.b.a.b.f65183a.g(aVar, fVar.a(), a2);
                }
            }
        }
        if (mVar != null) {
            c.a aVar3 = new c.a();
            aVar3.g(com.bytedance.sdk.a.b.w.HTTP_2);
            aVar3.a(mVar.f65250b);
            aVar3.i(mVar.f65251c);
            aVar3.f(aVar.c());
            return aVar3;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<d.c.c.a.b.a.h.a> e(a0 a0Var) {
        v d2 = a0Var.d();
        ArrayList arrayList = new ArrayList(d2.a() + 4);
        arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.f65271f, a0Var.c()));
        arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.f65272g, e.k.a(a0Var.a())));
        String b2 = a0Var.b("Host");
        if (b2 != null) {
            arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.i, b2));
        }
        arrayList.add(new d.c.c.a.b.a.h.a(d.c.c.a.b.a.h.a.f65273h, a0Var.a().m()));
        int a2 = d2.a();
        for (int i2 = 0; i2 < a2; i2++) {
            com.bytedance.sdk.a.a.f a3 = com.bytedance.sdk.a.a.f.a(d2.b(i2).toLowerCase(Locale.US));
            if (!n.contains(a3)) {
                arrayList.add(new d.c.c.a.b.a.h.a(a3, d2.e(i2)));
            }
        }
        return arrayList;
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public void a(a0 a0Var) throws IOException {
        if (this.f65306e != null) {
            return;
        }
        g p = this.f65305d.p(e(a0Var), a0Var.e() != null);
        this.f65306e = p;
        p.l().b(this.f65303b.c(), TimeUnit.MILLISECONDS);
        this.f65306e.m().b(this.f65303b.d(), TimeUnit.MILLISECONDS);
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public void b() throws IOException {
        this.f65306e.o().close();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public p c(a0 a0Var, long j2) {
        return this.f65306e.o();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public d.c.c.a.b.d b(d.c.c.a.b.c cVar) throws IOException {
        d.c.c.a.b.a.c.f fVar = this.f65304c;
        fVar.f65212f.t(fVar.f65211e);
        return new e.j(cVar.o("Content-Type"), e.g.c(cVar), d.c.c.a.a.k.b(new a(this.f65306e.n())));
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public void a() throws IOException {
        this.f65305d.C();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public c.a a(boolean z) throws IOException {
        c.a d2 = d(this.f65306e.j());
        if (z && d.c.c.a.b.a.b.f65183a.a(d2) == 100) {
            return null;
        }
        return d2;
    }
}
