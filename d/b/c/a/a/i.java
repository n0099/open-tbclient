package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class i implements q {

    /* renamed from: f  reason: collision with root package name */
    public final e f65168f;

    /* renamed from: g  reason: collision with root package name */
    public final Inflater f65169g;

    /* renamed from: h  reason: collision with root package name */
    public final j f65170h;

    /* renamed from: e  reason: collision with root package name */
    public int f65167e = 0;

    /* renamed from: i  reason: collision with root package name */
    public final CRC32 f65171i = new CRC32();

    public i(q qVar) {
        if (qVar != null) {
            this.f65169g = new Inflater(true);
            e b2 = k.b(qVar);
            this.f65168f = b2;
            this.f65170h = new j(b2, this.f65169g);
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
            if (this.f65167e == 0) {
                n();
                this.f65167e = 1;
            }
            if (this.f65167e == 1) {
                long j2 = cVar.f65162f;
                long a2 = this.f65170h.a(cVar, j);
                if (a2 != -1) {
                    c(cVar, j2, a2);
                    return a2;
                }
                this.f65167e = 2;
            }
            if (this.f65167e == 2) {
                o();
                this.f65167e = 3;
                if (!this.f65168f.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    public final void c(c cVar, long j, long j2) {
        int i2;
        n nVar = cVar.f65161e;
        while (true) {
            int i3 = nVar.f65190c;
            int i4 = nVar.f65189b;
            if (j < i3 - i4) {
                break;
            }
            j -= i3 - i4;
            nVar = nVar.f65193f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.f65190c - i2, j2);
            this.f65171i.update(nVar.f65188a, (int) (nVar.f65189b + j), min);
            j2 -= min;
            nVar = nVar.f65193f;
            j = 0;
        }
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f65170h.close();
    }

    public final void d(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public final void n() throws IOException {
        this.f65168f.a(10L);
        byte u = this.f65168f.c().u(3L);
        boolean z = ((u >> 1) & 1) == 1;
        if (z) {
            c(this.f65168f.c(), 0L, 10L);
        }
        d("ID1ID2", 8075, this.f65168f.i());
        this.f65168f.g(8L);
        if (((u >> 2) & 1) == 1) {
            this.f65168f.a(2L);
            if (z) {
                c(this.f65168f.c(), 0L, 2L);
            }
            long k = this.f65168f.c().k();
            this.f65168f.a(k);
            if (z) {
                c(this.f65168f.c(), 0L, k);
            }
            this.f65168f.g(k);
        }
        if (((u >> 3) & 1) == 1) {
            long k2 = this.f65168f.k((byte) 0);
            if (k2 != -1) {
                if (z) {
                    c(this.f65168f.c(), 0L, k2 + 1);
                }
                this.f65168f.g(k2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((u >> 4) & 1) == 1) {
            long k3 = this.f65168f.k((byte) 0);
            if (k3 != -1) {
                if (z) {
                    c(this.f65168f.c(), 0L, k3 + 1);
                }
                this.f65168f.g(k3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            d("FHCRC", this.f65168f.k(), (short) this.f65171i.getValue());
            this.f65171i.reset();
        }
    }

    public final void o() throws IOException {
        d("CRC", this.f65168f.l(), (int) this.f65171i.getValue());
        d("ISIZE", this.f65168f.l(), (int) this.f65169g.getBytesWritten());
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f65168f.a();
    }
}
