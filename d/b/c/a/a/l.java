package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f69016e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f69017f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69018g;

    public l(p pVar) {
        if (pVar != null) {
            this.f69017f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return this.f69017f.a();
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f69018g) {
            this.f69016e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.e
    public c c() {
        return this.f69016e;
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f69018g) {
            return;
        }
        try {
            if (this.f69016e.f68997f > 0) {
                this.f69017f.b(this.f69016e, this.f69016e.f68997f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f69017f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f69018g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f69018g) {
            c cVar = this.f69016e;
            long j = cVar.f68997f;
            if (j > 0) {
                this.f69017f.b(cVar, j);
            }
            this.f69017f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d g(int i2) throws IOException {
        if (!this.f69018g) {
            this.f69016e.B(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(int i2) throws IOException {
        if (!this.f69018g) {
            this.f69016e.z(i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d i(int i2) throws IOException {
        if (!this.f69018g) {
            this.f69016e.w(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f69018g;
    }

    public String toString() {
        return "buffer(" + this.f69017f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.b.c.a.a.d
    public d u() throws IOException {
        if (!this.f69018g) {
            long G = this.f69016e.G();
            if (G > 0) {
                this.f69017f.b(this.f69016e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f69018g) {
            int write = this.f69016e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f69018g) {
            this.f69016e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f69018g) {
            this.f69016e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f69018g) {
            this.f69016e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f69018g) {
            this.f69016e.y(bArr, i2, i3);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
