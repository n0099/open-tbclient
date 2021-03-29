package d.c.c.a.b.a.h;

import d.c.c.a.b.a.h.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public final class h implements Closeable {
    public static final Logger k = Logger.getLogger(c.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public final d.c.c.a.a.d f65375e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f65376f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.c.a.a.c f65377g;

    /* renamed from: h  reason: collision with root package name */
    public int f65378h;
    public boolean i;
    public final b.C1789b j;

    public h(d.c.c.a.a.d dVar, boolean z) {
        this.f65375e = dVar;
        this.f65376f = z;
        d.c.c.a.a.c cVar = new d.c.c.a.a.c();
        this.f65377g = cVar;
        this.j = new b.C1789b(cVar);
        this.f65378h = 16384;
    }

    public static void u(d.c.c.a.a.d dVar, int i) throws IOException {
        dVar.i((i >>> 16) & 255);
        dVar.i((i >>> 8) & 255);
        dVar.i(i & 255);
    }

    public synchronized void A() throws IOException {
        if (!this.i) {
            this.f65375e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void B(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f65378h, j);
            long j2 = min;
            j -= j2;
            p(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f65375e.b(this.f65377g, j2);
        }
    }

    public synchronized void C(l lVar) throws IOException {
        if (!this.i) {
            int i = 0;
            p(0, lVar.e() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (lVar.d(i)) {
                    this.f65375e.h(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f65375e.g(lVar.f(i));
                }
                i++;
            }
            this.f65375e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public int D() {
        return this.f65378h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.i = true;
        this.f65375e.close();
    }

    public synchronized void n() throws IOException {
        if (!this.i) {
            if (this.f65376f) {
                if (k.isLoggable(Level.FINE)) {
                    k.fine(d.c.c.a.b.a.e.j(">> CONNECTION %s", c.f65296a.e()));
                }
                this.f65375e.c(c.f65296a.h());
                this.f65375e.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public void o(int i, byte b2, d.c.c.a.a.c cVar, int i2) throws IOException {
        p(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f65375e.b(cVar, i2);
        }
    }

    public void p(int i, int i2, byte b2, byte b3) throws IOException {
        if (k.isLoggable(Level.FINE)) {
            k.fine(c.c(false, i, i2, b2, b3));
        }
        int i3 = this.f65378h;
        if (i2 > i3) {
            c.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) != 0) {
            c.a("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        } else {
            u(this.f65375e, i2);
            this.f65375e.i(b2 & 255);
            this.f65375e.i(b3 & 255);
            this.f65375e.g(i & Integer.MAX_VALUE);
        }
    }

    public synchronized void q(int i, int i2, List<a> list) throws IOException {
        if (!this.i) {
            this.j.f(list);
            long v = this.f65377g.v();
            int min = (int) Math.min(this.f65378h - 4, v);
            long j = min;
            int i3 = (v > j ? 1 : (v == j ? 0 : -1));
            p(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
            this.f65375e.g(i2 & Integer.MAX_VALUE);
            this.f65375e.b(this.f65377g, j);
            if (i3 > 0) {
                B(i, v - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void r(int i, long j) throws IOException {
        if (this.i) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            p(i, 4, (byte) 8, (byte) 0);
            this.f65375e.g((int) j);
            this.f65375e.flush();
        } else {
            c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public synchronized void s(int i, com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (!this.i) {
            if (bVar.f27177g != -1) {
                p(i, 4, (byte) 3, (byte) 0);
                this.f65375e.g(bVar.f27177g);
                this.f65375e.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void t(int i, com.bytedance.sdk.a.b.a.e.b bVar, byte[] bArr) throws IOException {
        if (!this.i) {
            if (bVar.f27177g != -1) {
                p(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f65375e.g(i);
                this.f65375e.g(bVar.f27177g);
                if (bArr.length > 0) {
                    this.f65375e.c(bArr);
                }
                this.f65375e.flush();
            } else {
                c.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void v(l lVar) throws IOException {
        if (!this.i) {
            this.f65378h = lVar.j(this.f65378h);
            if (lVar.g() != -1) {
                this.j.b(lVar.g());
            }
            p(0, 0, (byte) 4, (byte) 1);
            this.f65375e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void w(boolean z, int i, int i2) throws IOException {
        if (!this.i) {
            p(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f65375e.g(i);
            this.f65375e.g(i2);
            this.f65375e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void x(boolean z, int i, int i2, List<a> list) throws IOException {
        if (!this.i) {
            z(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void y(boolean z, int i, d.c.c.a.a.c cVar, int i2) throws IOException {
        if (!this.i) {
            o(i, z ? (byte) 1 : (byte) 0, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public void z(boolean z, int i, List<a> list) throws IOException {
        if (!this.i) {
            this.j.f(list);
            long v = this.f65377g.v();
            int min = (int) Math.min(this.f65378h, v);
            long j = min;
            int i2 = (v > j ? 1 : (v == j ? 0 : -1));
            byte b2 = i2 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            p(i, min, (byte) 1, b2);
            this.f65375e.b(this.f65377g, j);
            if (i2 > 0) {
                B(i, v - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
