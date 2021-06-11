package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f68912e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f68913f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68914g;

    public l(p pVar) {
        if (pVar != null) {
            this.f68913f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return this.f68913f.a();
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f68914g) {
            this.f68912e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.e
    public c c() {
        return this.f68912e;
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f68914g) {
            return;
        }
        try {
            if (this.f68912e.f68893f > 0) {
                this.f68913f.b(this.f68912e, this.f68912e.f68893f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f68913f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f68914g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f68914g) {
            c cVar = this.f68912e;
            long j = cVar.f68893f;
            if (j > 0) {
                this.f68913f.b(cVar, j);
            }
            this.f68913f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d g(int i2) throws IOException {
        if (!this.f68914g) {
            this.f68912e.B(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(int i2) throws IOException {
        if (!this.f68914g) {
            this.f68912e.z(i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d i(int i2) throws IOException {
        if (!this.f68914g) {
            this.f68912e.w(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f68914g;
    }

    public String toString() {
        return "buffer(" + this.f68913f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.b.c.a.a.d
    public d u() throws IOException {
        if (!this.f68914g) {
            long G = this.f68912e.G();
            if (G > 0) {
                this.f68913f.b(this.f68912e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f68914g) {
            int write = this.f68912e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f68914g) {
            this.f68912e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f68914g) {
            this.f68912e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f68914g) {
            this.f68912e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f68914g) {
            this.f68912e.y(bArr, i2, i3);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
