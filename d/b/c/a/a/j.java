package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f68903e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f68904f;

    /* renamed from: g  reason: collision with root package name */
    public int f68905g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68906h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f68903e = eVar;
            this.f68904f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f68906h) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f68904f.inflate(D.f68919a, D.f68921c, (int) Math.min(j, 8192 - D.f68921c));
                    if (inflate > 0) {
                        D.f68921c += inflate;
                        long j2 = inflate;
                        cVar.f68893f += j2;
                        return j2;
                    } else if (this.f68904f.finished() || this.f68904f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f68920b == D.f68921c) {
                cVar.f68892e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f68906h) {
            return;
        }
        this.f68904f.end();
        this.f68906h = true;
        this.f68903e.close();
    }

    public final boolean n() throws IOException {
        if (this.f68904f.needsInput()) {
            o();
            if (this.f68904f.getRemaining() == 0) {
                if (this.f68903e.e()) {
                    return true;
                }
                n nVar = this.f68903e.c().f68892e;
                int i2 = nVar.f68921c;
                int i3 = nVar.f68920b;
                int i4 = i2 - i3;
                this.f68905g = i4;
                this.f68904f.setInput(nVar.f68919a, i3, i4);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i2 = this.f68905g;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f68904f.getRemaining();
        this.f68905g -= remaining;
        this.f68903e.g(remaining);
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f68903e.a();
    }
}
