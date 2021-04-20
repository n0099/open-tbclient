package d.c.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f65984e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f65985f;

    /* renamed from: g  reason: collision with root package name */
    public int f65986g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65987h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f65984e = eVar;
            this.f65985f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.c.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.f65987h) {
                throw new IllegalStateException("closed");
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f65985f.inflate(D.f66000a, D.f66002c, (int) Math.min(j, 8192 - D.f66002c));
                    if (inflate > 0) {
                        D.f66002c += inflate;
                        long j2 = inflate;
                        cVar.f65975f += j2;
                        return j2;
                    } else if (this.f65985f.finished() || this.f65985f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f66001b == D.f66002c) {
                cVar.f65974e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65987h) {
            return;
        }
        this.f65985f.end();
        this.f65987h = true;
        this.f65984e.close();
    }

    public final boolean n() throws IOException {
        if (this.f65985f.needsInput()) {
            o();
            if (this.f65985f.getRemaining() == 0) {
                if (this.f65984e.e()) {
                    return true;
                }
                n nVar = this.f65984e.c().f65974e;
                int i = nVar.f66002c;
                int i2 = nVar.f66001b;
                int i3 = i - i2;
                this.f65986g = i3;
                this.f65985f.setInput(nVar.f66000a, i2, i3);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i = this.f65986g;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f65985f.getRemaining();
        this.f65986g -= remaining;
        this.f65984e.g(remaining);
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65984e.a();
    }
}
