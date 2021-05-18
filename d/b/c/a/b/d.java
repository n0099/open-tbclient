package d.b.c.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class d implements Closeable {

    /* loaded from: classes6.dex */
    public static class a extends d {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f65486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f65487f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.a.e f65488g;

        public a(x xVar, long j, d.b.c.a.a.e eVar) {
            this.f65486e = xVar;
            this.f65487f = j;
            this.f65488g = eVar;
        }

        @Override // d.b.c.a.b.d
        public x n() {
            return this.f65486e;
        }

        @Override // d.b.c.a.b.d
        public long o() {
            return this.f65487f;
        }

        @Override // d.b.c.a.b.d
        public d.b.c.a.a.e r() {
            return this.f65488g;
        }
    }

    public static d c(x xVar, long j, d.b.c.a.a.e eVar) {
        if (eVar != null) {
            return new a(xVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static d d(x xVar, byte[] bArr) {
        d.b.c.a.a.c cVar = new d.b.c.a.a.c();
        cVar.x(bArr);
        return c(xVar, bArr.length, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.b.c.a.b.a.e.q(r());
    }

    public abstract x n();

    public abstract long o();

    public final InputStream q() {
        return r().f();
    }

    public abstract d.b.c.a.a.e r();

    public final String s() throws IOException {
        d.b.c.a.a.e r = r();
        try {
            return r.i(d.b.c.a.b.a.e.l(r, t()));
        } finally {
            d.b.c.a.b.a.e.q(r);
        }
    }

    public final Charset t() {
        x n = n();
        return n != null ? n.c(d.b.c.a.b.a.e.j) : d.b.c.a.b.a.e.j;
    }
}
