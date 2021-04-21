package d.c.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class i implements q {

    /* renamed from: f  reason: collision with root package name */
    public final e f66076f;

    /* renamed from: g  reason: collision with root package name */
    public final Inflater f66077g;

    /* renamed from: h  reason: collision with root package name */
    public final j f66078h;

    /* renamed from: e  reason: collision with root package name */
    public int f66075e = 0;
    public final CRC32 i = new CRC32();

    public i(q qVar) {
        if (qVar != null) {
            this.f66077g = new Inflater(true);
            e b2 = k.b(qVar);
            this.f66076f = b2;
            this.f66078h = new j(b2, this.f66077g);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // d.c.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0L;
        } else {
            if (this.f66075e == 0) {
                n();
                this.f66075e = 1;
            }
            if (this.f66075e == 1) {
                long j2 = cVar.f66070f;
                long a2 = this.f66078h.a(cVar, j);
                if (a2 != -1) {
                    c(cVar, j2, a2);
                    return a2;
                }
                this.f66075e = 2;
            }
            if (this.f66075e == 2) {
                o();
                this.f66075e = 3;
                if (!this.f66076f.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    public final void c(c cVar, long j, long j2) {
        int i;
        n nVar = cVar.f66069e;
        while (true) {
            int i2 = nVar.f66097c;
            int i3 = nVar.f66096b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            nVar = nVar.f66100f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.f66097c - i, j2);
            this.i.update(nVar.f66095a, (int) (nVar.f66096b + j), min);
            j2 -= min;
            nVar = nVar.f66100f;
            j = 0;
        }
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f66078h.close();
    }

    public final void d(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public final void n() throws IOException {
        this.f66076f.a(10L);
        byte u = this.f66076f.c().u(3L);
        boolean z = ((u >> 1) & 1) == 1;
        if (z) {
            c(this.f66076f.c(), 0L, 10L);
        }
        d("ID1ID2", 8075, this.f66076f.i());
        this.f66076f.g(8L);
        if (((u >> 2) & 1) == 1) {
            this.f66076f.a(2L);
            if (z) {
                c(this.f66076f.c(), 0L, 2L);
            }
            long k = this.f66076f.c().k();
            this.f66076f.a(k);
            if (z) {
                c(this.f66076f.c(), 0L, k);
            }
            this.f66076f.g(k);
        }
        if (((u >> 3) & 1) == 1) {
            long k2 = this.f66076f.k((byte) 0);
            if (k2 != -1) {
                if (z) {
                    c(this.f66076f.c(), 0L, k2 + 1);
                }
                this.f66076f.g(k2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((u >> 4) & 1) == 1) {
            long k3 = this.f66076f.k((byte) 0);
            if (k3 != -1) {
                if (z) {
                    c(this.f66076f.c(), 0L, k3 + 1);
                }
                this.f66076f.g(k3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            d("FHCRC", this.f66076f.k(), (short) this.i.getValue());
            this.i.reset();
        }
    }

    public final void o() throws IOException {
        d("CRC", this.f66076f.l(), (int) this.i.getValue());
        d("ISIZE", this.f66076f.l(), (int) this.f66077g.getBytesWritten());
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f66076f.a();
    }
}
