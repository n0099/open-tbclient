package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f65993e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f65994f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65995g;

    public l(p pVar) {
        if (pVar != null) {
            this.f65994f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.c.c.a.a.p
    public r a() {
        return this.f65994f.a();
    }

    @Override // d.c.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f65995g) {
            this.f65993e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.e
    public c c() {
        return this.f65993e;
    }

    @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65995g) {
            return;
        }
        try {
            if (this.f65993e.f65975f > 0) {
                this.f65994f.b(this.f65993e, this.f65993e.f65975f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f65994f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f65995g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f65995g) {
            c cVar = this.f65993e;
            long j = cVar.f65975f;
            if (j > 0) {
                this.f65994f.b(cVar, j);
            }
            this.f65994f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d g(int i) throws IOException {
        if (!this.f65995g) {
            this.f65993e.B(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(int i) throws IOException {
        if (!this.f65995g) {
            this.f65993e.z(i);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d i(int i) throws IOException {
        if (!this.f65995g) {
            this.f65993e.w(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f65995g;
    }

    public String toString() {
        return "buffer(" + this.f65994f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.c.c.a.a.d
    public d u() throws IOException {
        if (!this.f65995g) {
            long G = this.f65993e.G();
            if (G > 0) {
                this.f65994f.b(this.f65993e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f65995g) {
            int write = this.f65993e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f65995g) {
            this.f65993e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f65995g) {
            this.f65993e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f65995g) {
            this.f65993e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f65995g) {
            this.f65993e.y(bArr, i, i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
