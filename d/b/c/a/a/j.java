package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f65172e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f65173f;

    /* renamed from: g  reason: collision with root package name */
    public int f65174g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65175h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f65172e = eVar;
            this.f65173f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f65175h) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f65173f.inflate(D.f65188a, D.f65190c, (int) Math.min(j, 8192 - D.f65190c));
                    if (inflate > 0) {
                        D.f65190c += inflate;
                        long j2 = inflate;
                        cVar.f65162f += j2;
                        return j2;
                    } else if (this.f65173f.finished() || this.f65173f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f65189b == D.f65190c) {
                cVar.f65161e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65175h) {
            return;
        }
        this.f65173f.end();
        this.f65175h = true;
        this.f65172e.close();
    }

    public final boolean n() throws IOException {
        if (this.f65173f.needsInput()) {
            o();
            if (this.f65173f.getRemaining() == 0) {
                if (this.f65172e.e()) {
                    return true;
                }
                n nVar = this.f65172e.c().f65161e;
                int i2 = nVar.f65190c;
                int i3 = nVar.f65189b;
                int i4 = i2 - i3;
                this.f65174g = i4;
                this.f65173f.setInput(nVar.f65188a, i3, i4);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i2 = this.f65174g;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f65173f.getRemaining();
        this.f65174g -= remaining;
        this.f65172e.g(remaining);
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f65172e.a();
    }
}
