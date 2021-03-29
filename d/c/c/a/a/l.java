package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f65148e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f65149f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65150g;

    public l(p pVar) {
        if (pVar != null) {
            this.f65149f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.c.c.a.a.p
    public r a() {
        return this.f65149f.a();
    }

    @Override // d.c.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f65150g) {
            this.f65148e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.e
    public c c() {
        return this.f65148e;
    }

    @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65150g) {
            return;
        }
        try {
            if (this.f65148e.f65130f > 0) {
                this.f65149f.b(this.f65148e, this.f65148e.f65130f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f65149f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f65150g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f65150g) {
            c cVar = this.f65148e;
            long j = cVar.f65130f;
            if (j > 0) {
                this.f65149f.b(cVar, j);
            }
            this.f65149f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d g(int i) throws IOException {
        if (!this.f65150g) {
            this.f65148e.B(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(int i) throws IOException {
        if (!this.f65150g) {
            this.f65148e.z(i);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d i(int i) throws IOException {
        if (!this.f65150g) {
            this.f65148e.w(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f65150g;
    }

    public String toString() {
        return "buffer(" + this.f65149f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.c.c.a.a.d
    public d u() throws IOException {
        if (!this.f65150g) {
            long G = this.f65148e.G();
            if (G > 0) {
                this.f65149f.b(this.f65148e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f65150g) {
            int write = this.f65148e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f65150g) {
            this.f65148e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f65150g) {
            this.f65148e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f65150g) {
            this.f65148e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f65150g) {
            this.f65148e.y(bArr, i, i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
