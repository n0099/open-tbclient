package d.c.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class i implements q {

    /* renamed from: f  reason: collision with root package name */
    public final e f65136f;

    /* renamed from: g  reason: collision with root package name */
    public final Inflater f65137g;

    /* renamed from: h  reason: collision with root package name */
    public final j f65138h;

    /* renamed from: e  reason: collision with root package name */
    public int f65135e = 0;
    public final CRC32 i = new CRC32();

    public i(q qVar) {
        if (qVar != null) {
            this.f65137g = new Inflater(true);
            e b2 = k.b(qVar);
            this.f65136f = b2;
            this.f65138h = new j(b2, this.f65137g);
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
            if (this.f65135e == 0) {
                n();
                this.f65135e = 1;
            }
            if (this.f65135e == 1) {
                long j2 = cVar.f65130f;
                long a2 = this.f65138h.a(cVar, j);
                if (a2 != -1) {
                    c(cVar, j2, a2);
                    return a2;
                }
                this.f65135e = 2;
            }
            if (this.f65135e == 2) {
                o();
                this.f65135e = 3;
                if (!this.f65136f.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    public final void c(c cVar, long j, long j2) {
        int i;
        n nVar = cVar.f65129e;
        while (true) {
            int i2 = nVar.f65157c;
            int i3 = nVar.f65156b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            nVar = nVar.f65160f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.f65157c - i, j2);
            this.i.update(nVar.f65155a, (int) (nVar.f65156b + j), min);
            j2 -= min;
            nVar = nVar.f65160f;
            j = 0;
        }
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f65138h.close();
    }

    public final void d(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public final void n() throws IOException {
        this.f65136f.a(10L);
        byte u = this.f65136f.c().u(3L);
        boolean z = ((u >> 1) & 1) == 1;
        if (z) {
            c(this.f65136f.c(), 0L, 10L);
        }
        d("ID1ID2", 8075, this.f65136f.i());
        this.f65136f.g(8L);
        if (((u >> 2) & 1) == 1) {
            this.f65136f.a(2L);
            if (z) {
                c(this.f65136f.c(), 0L, 2L);
            }
            long k = this.f65136f.c().k();
            this.f65136f.a(k);
            if (z) {
                c(this.f65136f.c(), 0L, k);
            }
            this.f65136f.g(k);
        }
        if (((u >> 3) & 1) == 1) {
            long k2 = this.f65136f.k((byte) 0);
            if (k2 != -1) {
                if (z) {
                    c(this.f65136f.c(), 0L, k2 + 1);
                }
                this.f65136f.g(k2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((u >> 4) & 1) == 1) {
            long k3 = this.f65136f.k((byte) 0);
            if (k3 != -1) {
                if (z) {
                    c(this.f65136f.c(), 0L, k3 + 1);
                }
                this.f65136f.g(k3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            d("FHCRC", this.f65136f.k(), (short) this.i.getValue());
            this.i.reset();
        }
    }

    public final void o() throws IOException {
        d("CRC", this.f65136f.l(), (int) this.i.getValue());
        d("ISIZE", this.f65136f.l(), (int) this.f65137g.getBytesWritten());
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65136f.a();
    }
}
