package d.c.c.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes4.dex */
public final class j implements q {

    /* renamed from: e  reason: collision with root package name */
    public final e f65138e;

    /* renamed from: f  reason: collision with root package name */
    public final Inflater f65139f;

    /* renamed from: g  reason: collision with root package name */
    public int f65140g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65141h;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f65138e = eVar;
            this.f65139f = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        o();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r1.f65155b != r1.f65156c) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        r7.f65128e = r1.e();
        d.c.c.a.a.o.b(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return -1;
     */
    @Override // d.c.c.a.a.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(c cVar, long j) throws IOException {
        if (j >= 0) {
            if (this.f65141h) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return 0L;
            }
            while (true) {
                boolean n = n();
                try {
                    n D = cVar.D(1);
                    int inflate = this.f65139f.inflate(D.f65154a, D.f65156c, (int) Math.min(j, 8192 - D.f65156c));
                    if (inflate > 0) {
                        D.f65156c += inflate;
                        long j2 = inflate;
                        cVar.f65129f += j2;
                        return j2;
                    } else if (this.f65139f.finished() || this.f65139f.needsDictionary()) {
                        break;
                    } else if (n) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65141h) {
            return;
        }
        this.f65139f.end();
        this.f65141h = true;
        this.f65138e.close();
    }

    public final boolean n() throws IOException {
        if (this.f65139f.needsInput()) {
            o();
            if (this.f65139f.getRemaining() == 0) {
                if (this.f65138e.e()) {
                    return true;
                }
                n nVar = this.f65138e.c().f65128e;
                int i = nVar.f65156c;
                int i2 = nVar.f65155b;
                int i3 = i - i2;
                this.f65140g = i3;
                this.f65139f.setInput(nVar.f65154a, i2, i3);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void o() throws IOException {
        int i = this.f65140g;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f65139f.getRemaining();
        this.f65140g -= remaining;
        this.f65138e.g(remaining);
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65138e.a();
    }
}
