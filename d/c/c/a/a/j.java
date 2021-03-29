package d.c.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f65139e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f65140f;

    /* renamed from: g  reason: collision with root package name */
    public int f65141g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65142h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f65139e = eVar;
            this.f65140f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.c.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.f65142h) {
                throw new IllegalStateException("closed");
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f65140f.inflate(D.f65155a, D.f65157c, (int) Math.min(j, 8192 - D.f65157c));
                    if (inflate > 0) {
                        D.f65157c += inflate;
                        long j2 = inflate;
                        cVar.f65130f += j2;
                        return j2;
                    } else if (this.f65140f.finished() || this.f65140f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f65156b == D.f65157c) {
                cVar.f65129e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65142h) {
            return;
        }
        this.f65140f.end();
        this.f65142h = true;
        this.f65139e.close();
    }

    public final boolean n() throws IOException {
        if (this.f65140f.needsInput()) {
            o();
            if (this.f65140f.getRemaining() == 0) {
                if (this.f65139e.e()) {
                    return true;
                }
                n nVar = this.f65139e.c().f65129e;
                int i = nVar.f65157c;
                int i2 = nVar.f65156b;
                int i3 = i - i2;
                this.f65141g = i3;
                this.f65140f.setInput(nVar.f65155a, i2, i3);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i = this.f65141g;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f65140f.getRemaining();
        this.f65141g -= remaining;
        this.f65139e.g(remaining);
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65139e.a();
    }
}
