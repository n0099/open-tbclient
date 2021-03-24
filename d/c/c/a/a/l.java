package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class l implements d {

    /* renamed from: e  reason: collision with root package name */
    public final c f65147e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final p f65148f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65149g;

    public l(p pVar) {
        if (pVar != null) {
            this.f65148f = pVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // d.c.c.a.a.p
    public r a() {
        return this.f65148f.a();
    }

    @Override // d.c.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        if (!this.f65149g) {
            this.f65147e.b(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.e
    public c c() {
        return this.f65147e;
    }

    @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65149g) {
            return;
        }
        try {
            if (this.f65147e.f65129f > 0) {
                this.f65148f.b(this.f65147e, this.f65147e.f65129f);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f65148f.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f65149g = true;
        if (th == null) {
            return;
        }
        s.d(th);
        throw null;
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f65149g) {
            c cVar = this.f65147e;
            long j = cVar.f65129f;
            if (j > 0) {
                this.f65148f.b(cVar, j);
            }
            this.f65148f.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d g(int i) throws IOException {
        if (!this.f65149g) {
            this.f65147e.B(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(int i) throws IOException {
        if (!this.f65149g) {
            this.f65147e.z(i);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d i(int i) throws IOException {
        if (!this.f65149g) {
            this.f65147e.w(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f65149g;
    }

    public String toString() {
        return "buffer(" + this.f65148f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.c.c.a.a.d
    public d u() throws IOException {
        if (!this.f65149g) {
            long G = this.f65147e.G();
            if (G > 0) {
                this.f65148f.b(this.f65147e, G);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f65149g) {
            int write = this.f65147e.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.f65149g) {
            this.f65147e.x(bArr);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d b(String str) throws IOException {
        if (!this.f65149g) {
            this.f65147e.p(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d h(long j) throws IOException {
        if (!this.f65149g) {
            this.f65147e.H(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f65149g) {
            this.f65147e.y(bArr, i, i2);
            u();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
