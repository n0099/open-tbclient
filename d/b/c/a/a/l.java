package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f65138e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f65139f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65140g;

    public l(p pVar) {
        if (pVar != null) {
            this.f65139f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return this.f65139f.a();
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f65140g) {
            this.f65138e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.e
    public c c() {
        return this.f65138e;
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65140g) {
            return;
        }
        try {
            if (this.f65138e.f65119f > 0) {
                this.f65139f.b(this.f65138e, this.f65138e.f65119f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f65139f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f65140g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f65140g) {
            c cVar = this.f65138e;
            long j = cVar.f65119f;
            if (j > 0) {
                this.f65139f.b(cVar, j);
            }
            this.f65139f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d g(int i2) throws IOException {
        if (!this.f65140g) {
            this.f65138e.B(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(int i2) throws IOException {
        if (!this.f65140g) {
            this.f65138e.z(i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d i(int i2) throws IOException {
        if (!this.f65140g) {
            this.f65138e.w(i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f65140g;
    }

    public String toString() {
        return "buffer(" + this.f65139f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.b.c.a.a.d
    public d u() throws IOException {
        if (!this.f65140g) {
            long G = this.f65138e.G();
            if (G > 0) {
                this.f65139f.b(this.f65138e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f65140g) {
            int write = this.f65138e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f65140g) {
            this.f65138e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f65140g) {
            this.f65138e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f65140g) {
            this.f65138e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.d
    public d c(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f65140g) {
            this.f65138e.y(bArr, i2, i3);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
