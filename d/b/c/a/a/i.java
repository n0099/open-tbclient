package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class i implements q {

    /* renamed from: f  reason: collision with root package name */
    public final e f68899f;

    /* renamed from: g  reason: collision with root package name */
    public final Inflater f68900g;

    /* renamed from: h  reason: collision with root package name */
    public final j f68901h;

    /* renamed from: e  reason: collision with root package name */
    public int f68898e = 0;

    /* renamed from: i  reason: collision with root package name */
    public final CRC32 f68902i = new CRC32();

    public i(q qVar) {
        if (qVar != null) {
            this.f68900g = new Inflater(true);
            e b2 = k.b(qVar);
            this.f68899f = b2;
            this.f68901h = new j(b2, this.f68900g);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i2 == 0) {
            return 0L;
        } else {
            if (this.f68898e == 0) {
                n();
                this.f68898e = 1;
            }
            if (this.f68898e == 1) {
                long j2 = cVar.f68893f;
                long a2 = this.f68901h.a(cVar, j);
                if (a2 != -1) {
                    c(cVar, j2, a2);
                    return a2;
                }
                this.f68898e = 2;
            }
            if (this.f68898e == 2) {
                o();
                this.f68898e = 3;
                if (!this.f68899f.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    public final void c(c cVar, long j, long j2) {
        int i2;
        n nVar = cVar.f68892e;
        while (true) {
            int i3 = nVar.f68921c;
            int i4 = nVar.f68920b;
            if (j < i3 - i4) {
                break;
            }
            j -= i3 - i4;
            nVar = nVar.f68924f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.f68921c - i2, j2);
            this.f68902i.update(nVar.f68919a, (int) (nVar.f68920b + j), min);
            j2 -= min;
            nVar = nVar.f68924f;
            j = 0;
        }
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f68901h.close();
    }

    public final void d(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public final void n() throws IOException {
        this.f68899f.a(10L);
        byte u = this.f68899f.c().u(3L);
        boolean z = ((u >> 1) & 1) == 1;
        if (z) {
            c(this.f68899f.c(), 0L, 10L);
        }
        d("ID1ID2", 8075, this.f68899f.i());
        this.f68899f.g(8L);
        if (((u >> 2) & 1) == 1) {
            this.f68899f.a(2L);
            if (z) {
                c(this.f68899f.c(), 0L, 2L);
            }
            long k = this.f68899f.c().k();
            this.f68899f.a(k);
            if (z) {
                c(this.f68899f.c(), 0L, k);
            }
            this.f68899f.g(k);
        }
        if (((u >> 3) & 1) == 1) {
            long k2 = this.f68899f.k((byte) 0);
            if (k2 != -1) {
                if (z) {
                    c(this.f68899f.c(), 0L, k2 + 1);
                }
                this.f68899f.g(k2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((u >> 4) & 1) == 1) {
            long k3 = this.f68899f.k((byte) 0);
            if (k3 != -1) {
                if (z) {
                    c(this.f68899f.c(), 0L, k3 + 1);
                }
                this.f68899f.g(k3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            d("FHCRC", this.f68899f.k(), (short) this.f68902i.getValue());
            this.f68902i.reset();
        }
    }

    public final void o() throws IOException {
        d("CRC", this.f68899f.l(), (int) this.f68902i.getValue());
        d("ISIZE", this.f68899f.l(), (int) this.f68900g.getBytesWritten());
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f68899f.a();
    }
}
