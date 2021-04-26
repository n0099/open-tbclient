package d.b.c.a.b.a.h;

import d.b.c.a.b.a.h.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public final class h implements Closeable {
    public static final Logger k = Logger.getLogger(c.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public final d.b.c.a.a.d f64699e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f64700f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.c.a.a.c f64701g;

    /* renamed from: h  reason: collision with root package name */
    public int f64702h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64703i;
    public final b.C1760b j;

    public h(d.b.c.a.a.d dVar, boolean z) {
        this.f64699e = dVar;
        this.f64700f = z;
        d.b.c.a.a.c cVar = new d.b.c.a.a.c();
        this.f64701g = cVar;
        this.j = new b.C1760b(cVar);
        this.f64702h = 16384;
    }

    public static void u(d.b.c.a.a.d dVar, int i2) throws IOException {
        dVar.i((i2 >>> 16) & 255);
        dVar.i((i2 >>> 8) & 255);
        dVar.i(i2 & 255);
    }

    public synchronized void A() throws IOException {
        if (!this.f64703i) {
            this.f64699e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void B(int i2, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f64702h, j);
            long j2 = min;
            j -= j2;
            p(i2, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f64699e.b(this.f64701g, j2);
        }
    }

    public synchronized void C(l lVar) throws IOException {
        if (!this.f64703i) {
            int i2 = 0;
            p(0, lVar.e() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (lVar.d(i2)) {
                    this.f64699e.h(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.f64699e.g(lVar.f(i2));
                }
                i2++;
            }
            this.f64699e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public int D() {
        return this.f64702h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f64703i = true;
        this.f64699e.close();
    }

    public synchronized void n() throws IOException {
        if (!this.f64703i) {
            if (this.f64700f) {
                if (k.isLoggable(Level.FINE)) {
                    k.fine(d.b.c.a.b.a.e.j(">> CONNECTION %s", c.f64610a.e()));
                }
                this.f64699e.c(c.f64610a.h());
                this.f64699e.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public void o(int i2, byte b2, d.b.c.a.a.c cVar, int i3) throws IOException {
        p(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.f64699e.b(cVar, i3);
        }
    }

    public void p(int i2, int i3, byte b2, byte b3) throws IOException {
        if (k.isLoggable(Level.FINE)) {
            k.fine(c.c(false, i2, i3, b2, b3));
        }
        int i4 = this.f64702h;
        if (i3 > i4) {
            c.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) != 0) {
            c.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        } else {
            u(this.f64699e, i3);
            this.f64699e.i(b2 & 255);
            this.f64699e.i(b3 & 255);
            this.f64699e.g(i2 & Integer.MAX_VALUE);
        }
    }

    public synchronized void q(int i2, int i3, List<a> list) throws IOException {
        if (!this.f64703i) {
            this.j.f(list);
            long v = this.f64701g.v();
            int min = (int) Math.min(this.f64702h - 4, v);
            long j = min;
            int i4 = (v > j ? 1 : (v == j ? 0 : -1));
            p(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
            this.f64699e.g(i3 & Integer.MAX_VALUE);
            this.f64699e.b(this.f64701g, j);
            if (i4 > 0) {
                B(i2, v - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void r(int i2, long j) throws IOException {
        if (this.f64703i) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            p(i2, 4, (byte) 8, (byte) 0);
            this.f64699e.g((int) j);
            this.f64699e.flush();
        } else {
            c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public synchronized void s(int i2, com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (!this.f64703i) {
            if (bVar.f27684g != -1) {
                p(i2, 4, (byte) 3, (byte) 0);
                this.f64699e.g(bVar.f27684g);
                this.f64699e.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void t(int i2, com.bytedance.sdk.a.b.a.e.b bVar, byte[] bArr) throws IOException {
        if (!this.f64703i) {
            if (bVar.f27684g != -1) {
                p(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f64699e.g(i2);
                this.f64699e.g(bVar.f27684g);
                if (bArr.length > 0) {
                    this.f64699e.c(bArr);
                }
                this.f64699e.flush();
            } else {
                c.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void v(l lVar) throws IOException {
        if (!this.f64703i) {
            this.f64702h = lVar.j(this.f64702h);
            if (lVar.g() != -1) {
                this.j.b(lVar.g());
            }
            p(0, 0, (byte) 4, (byte) 1);
            this.f64699e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void w(boolean z, int i2, int i3) throws IOException {
        if (!this.f64703i) {
            p(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f64699e.g(i2);
            this.f64699e.g(i3);
            this.f64699e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void x(boolean z, int i2, int i3, List<a> list) throws IOException {
        if (!this.f64703i) {
            z(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void y(boolean z, int i2, d.b.c.a.a.c cVar, int i3) throws IOException {
        if (!this.f64703i) {
            o(i2, z ? (byte) 1 : (byte) 0, cVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public void z(boolean z, int i2, List<a> list) throws IOException {
        if (!this.f64703i) {
            this.j.f(list);
            long v = this.f64701g.v();
            int min = (int) Math.min(this.f64702h, v);
            long j = min;
            int i3 = (v > j ? 1 : (v == j ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            p(i2, min, (byte) 1, b2);
            this.f64699e.b(this.f64701g, j);
            if (i3 > 0) {
                B(i2, v - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
