package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f66088e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f66089f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66090g;

    public l(p pVar) {
        if (pVar != null) {
            this.f66089f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.c.c.a.a.p
    public r a() {
        return this.f66089f.a();
    }

    @Override // d.c.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f66090g) {
            this.f66088e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.e
    public c c() {
        return this.f66088e;
    }

    @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f66090g) {
            return;
        }
        try {
            if (this.f66088e.f66070f > 0) {
                this.f66089f.b(this.f66088e, this.f66088e.f66070f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f66089f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f66090g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f66090g) {
            c cVar = this.f66088e;
            long j = cVar.f66070f;
            if (j > 0) {
                this.f66089f.b(cVar, j);
            }
            this.f66089f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d g(int i) throws IOException {
        if (!this.f66090g) {
            this.f66088e.B(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(int i) throws IOException {
        if (!this.f66090g) {
            this.f66088e.z(i);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d i(int i) throws IOException {
        if (!this.f66090g) {
            this.f66088e.w(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f66090g;
    }

    public String toString() {
        return "buffer(" + this.f66089f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.c.c.a.a.d
    public d u() throws IOException {
        if (!this.f66090g) {
            long G = this.f66088e.G();
            if (G > 0) {
                this.f66089f.b(this.f66088e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f66090g) {
            int write = this.f66088e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f66090g) {
            this.f66088e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f66090g) {
            this.f66088e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f66090g) {
            this.f66088e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f66090g) {
            this.f66088e.y(bArr, i, i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
