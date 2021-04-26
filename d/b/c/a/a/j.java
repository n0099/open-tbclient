package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f64443e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f64444f;

    /* renamed from: g  reason: collision with root package name */
    public int f64445g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64446h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f64443e = eVar;
            this.f64444f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f64446h) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f64444f.inflate(D.f64459a, D.f64461c, (int) Math.min(j, 8192 - D.f64461c));
                    if (inflate > 0) {
                        D.f64461c += inflate;
                        long j2 = inflate;
                        cVar.f64433f += j2;
                        return j2;
                    } else if (this.f64444f.finished() || this.f64444f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f64460b == D.f64461c) {
                cVar.f64432e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f64446h) {
            return;
        }
        this.f64444f.end();
        this.f64446h = true;
        this.f64443e.close();
    }

    public final boolean n() throws IOException {
        if (this.f64444f.needsInput()) {
            o();
            if (this.f64444f.getRemaining() == 0) {
                if (this.f64443e.e()) {
                    return true;
                }
                n nVar = this.f64443e.c().f64432e;
                int i2 = nVar.f64461c;
                int i3 = nVar.f64460b;
                int i4 = i2 - i3;
                this.f64445g = i4;
                this.f64444f.setInput(nVar.f64459a, i3, i4);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i2 = this.f64445g;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f64444f.getRemaining();
        this.f64445g -= remaining;
        this.f64443e.g(remaining);
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f64443e.a();
    }
}
