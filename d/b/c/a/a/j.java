package d.b.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f65129e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f65130f;

    /* renamed from: g  reason: collision with root package name */
    public int f65131g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65132h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f65129e = eVar;
            this.f65130f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        n D;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f65132h) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    D = cVar.D(1);
                    int inflate = this.f65130f.inflate(D.f65145a, D.f65147c, (int) Math.min(j, 8192 - D.f65147c));
                    if (inflate > 0) {
                        D.f65147c += inflate;
                        long j2 = inflate;
                        cVar.f65119f += j2;
                        return j2;
                    } else if (this.f65130f.finished() || this.f65130f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            o();
            if (D.f65146b == D.f65147c) {
                cVar.f65118e = D.e();
                o.b(D);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65132h) {
            return;
        }
        this.f65130f.end();
        this.f65132h = true;
        this.f65129e.close();
    }

    public final boolean n() throws IOException {
        if (this.f65130f.needsInput()) {
            o();
            if (this.f65130f.getRemaining() == 0) {
                if (this.f65129e.e()) {
                    return true;
                }
                n nVar = this.f65129e.c().f65118e;
                int i2 = nVar.f65147c;
                int i3 = nVar.f65146b;
                int i4 = i2 - i3;
                this.f65131g = i4;
                this.f65130f.setInput(nVar.f65145a, i3, i4);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i2 = this.f65131g;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f65130f.getRemaining();
        this.f65131g -= remaining;
        this.f65129e.g(remaining);
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f65129e.a();
    }
}
