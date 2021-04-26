package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f64452e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f64453f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64454g;

    public l(p pVar) {
        if (pVar != null) {
            this.f64453f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return this.f64453f.a();
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f64454g) {
            this.f64452e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.e
    public c c() {
        return this.f64452e;
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f64454g) {
            return;
        }
        try {
            if (this.f64452e.f64433f > 0) {
                this.f64453f.b(this.f64452e, this.f64452e.f64433f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f64453f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f64454g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f64454g) {
            c cVar = this.f64452e;
            long j = cVar.f64433f;
            if (j > 0) {
                this.f64453f.b(cVar, j);
            }
            this.f64453f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d g(int i2) throws IOException {
        if (!this.f64454g) {
            this.f64452e.B(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(int i2) throws IOException {
        if (!this.f64454g) {
            this.f64452e.z(i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d i(int i2) throws IOException {
        if (!this.f64454g) {
            this.f64452e.w(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f64454g;
    }

    public String toString() {
        return "buffer(" + this.f64453f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.b.c.a.a.d
    public d u() throws IOException {
        if (!this.f64454g) {
            long G = this.f64452e.G();
            if (G > 0) {
                this.f64453f.b(this.f64452e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f64454g) {
            int write = this.f64452e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f64454g) {
            this.f64452e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f64454g) {
            this.f64452e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f64454g) {
            this.f64452e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f64454g) {
            this.f64452e.y(bArr, i2, i3);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
