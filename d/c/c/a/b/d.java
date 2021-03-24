package d.c.c.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public abstract class d implements Closeable {

    /* loaded from: classes5.dex */
    public static class a extends d {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f65471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f65472f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.c.c.a.a.e f65473g;

        public a(x xVar, long j, d.c.c.a.a.e eVar) {
            this.f65471e = xVar;
            this.f65472f = j;
            this.f65473g = eVar;
        }

        @Override // d.c.c.a.b.d
        public x n() {
            return this.f65471e;
        }

        @Override // d.c.c.a.b.d
        public long o() {
            return this.f65472f;
        }

        @Override // d.c.c.a.b.d
        public d.c.c.a.a.e r() {
            return this.f65473g;
        }
    }

    public static d c(x xVar, long j, d.c.c.a.a.e eVar) {
        if (eVar != null) {
            return new a(xVar, j, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static d d(x xVar, byte[] bArr) {
        d.c.c.a.a.c cVar = new d.c.c.a.a.c();
        cVar.x(bArr);
        return c(xVar, bArr.length, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.c.c.a.b.a.e.q(r());
    }

    public abstract x n();

    public abstract long o();

    public final InputStream q() {
        return r().f();
    }

    public abstract d.c.c.a.a.e r();

    public final String s() throws IOException {
        d.c.c.a.a.e r = r();
        try {
            return r.i(d.c.c.a.b.a.e.l(r, t()));
        } finally {
            d.c.c.a.b.a.e.q(r);
        }
    }

    public final Charset t() {
        x n = n();
        return n != null ? n.c(d.c.c.a.b.a.e.j) : d.c.c.a.b.a.e.j;
    }
}
