package d.c.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f66079e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f66080f;

    /* renamed from: g  reason: collision with root package name */
    public int f66081g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66082h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f66079e = eVar;
            this.f66080f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.c.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.f66082h) {
                throw new IllegalStateException("closed");
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f66080f.inflate(D.f66095a, D.f66097c, (int) Math.min(j, 8192 - D.f66097c));
                    if (inflate > 0) {
                        D.f66097c += inflate;
                        long j2 = inflate;
                        cVar.f66070f += j2;
                        return j2;
                    } else if (this.f66080f.finished() || this.f66080f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f66096b == D.f66097c) {
                cVar.f66069e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f66082h) {
            return;
        }
        this.f66080f.end();
        this.f66082h = true;
        this.f66079e.close();
    }

    public final boolean n() throws IOException {
        if (this.f66080f.needsInput()) {
            o();
            if (this.f66080f.getRemaining() == 0) {
                if (this.f66079e.e()) {
                    return true;
                }
                n nVar = this.f66079e.c().f66069e;
                int i = nVar.f66097c;
                int i2 = nVar.f66096b;
                int i3 = i - i2;
                this.f66081g = i3;
                this.f66080f.setInput(nVar.f66095a, i2, i3);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i = this.f66081g;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f66080f.getRemaining();
        this.f66081g -= remaining;
        this.f66079e.g(remaining);
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f66079e.a();
    }
}
