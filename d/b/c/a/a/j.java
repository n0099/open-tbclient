package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f69007e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f69008f;

    /* renamed from: g  reason: collision with root package name */
    public int f69009g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69010h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f69007e = eVar;
            this.f69008f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f69010h) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f69008f.inflate(D.f69023a, D.f69025c, (int) Math.min(j, 8192 - D.f69025c));
                    if (inflate > 0) {
                        D.f69025c += inflate;
                        long j2 = inflate;
                        cVar.f68997f += j2;
                        return j2;
                    } else if (this.f69008f.finished() || this.f69008f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f69024b == D.f69025c) {
                cVar.f68996e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f69010h) {
            return;
        }
        this.f69008f.end();
        this.f69010h = true;
        this.f69007e.close();
    }

    public final boolean n() throws IOException {
        if (this.f69008f.needsInput()) {
            o();
            if (this.f69008f.getRemaining() == 0) {
                if (this.f69007e.e()) {
                    return true;
                }
                n nVar = this.f69007e.c().f68996e;
                int i2 = nVar.f69025c;
                int i3 = nVar.f69024b;
                int i4 = i2 - i3;
                this.f69009g = i4;
                this.f69008f.setInput(nVar.f69023a, i3, i4);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i2 = this.f69009g;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f69008f.getRemaining();
        this.f69009g -= remaining;
        this.f69007e.g(remaining);
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f69007e.a();
    }
}
