package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public final class m implements e {

    /* renamed from: e  reason: collision with root package name */
    public final c f64455e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final q f64456f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64457g;

    public m(q qVar) {
        if (qVar != null) {
            this.f64456f = qVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        if (cVar != null) {
            if (j >= 0) {
                if (!this.f64457g) {
                    c cVar2 = this.f64455e;
                    if (cVar2.f64433f == 0 && this.f64456f.a(cVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f64455e.a(cVar, Math.min(j, this.f64455e.f64433f));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // d.b.c.a.a.e
    public c c() {
        return this.f64455e;
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f64457g) {
            return;
        }
        this.f64457g = true;
        this.f64456f.close();
        this.f64455e.L();
    }

    public boolean d(long j, com.bytedance.sdk.a.a.f fVar, int i2, int i3) throws IOException {
        if (!this.f64457g) {
            if (j < 0 || i2 < 0 || i3 < 0 || fVar.g() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                long j2 = i4 + j;
                if (!l(1 + j2) || this.f64455e.u(j2) != fVar.a(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.b.c.a.a.e
    public boolean e() throws IOException {
        if (this.f64457g) {
            throw new IllegalStateException("closed");
        }
        return this.f64455e.e() && this.f64456f.a(this.f64455e, 8192L) == -1;
    }

    @Override // d.b.c.a.a.e
    public byte[] f(long j) throws IOException {
        a(j);
        return this.f64455e.f(j);
    }

    @Override // d.b.c.a.a.e
    public void g(long j) throws IOException {
        if (this.f64457g) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f64455e;
            if (cVar.f64433f == 0 && this.f64456f.a(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f64455e.v());
            this.f64455e.g(min);
            j -= min;
        }
    }

    @Override // d.b.c.a.a.e
    public byte h() throws IOException {
        a(1L);
        return this.f64455e.h();
    }

    @Override // d.b.c.a.a.e
    public String i(Charset charset) throws IOException {
        if (charset != null) {
            this.f64455e.l(this.f64456f);
            return this.f64455e.i(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f64457g;
    }

    @Override // d.b.c.a.a.e
    public int j() throws IOException {
        a(4L);
        return this.f64455e.j();
    }

    @Override // d.b.c.a.a.e
    public short k() throws IOException {
        a(2L);
        return this.f64455e.k();
    }

    public boolean l(long j) throws IOException {
        c cVar;
        if (j >= 0) {
            if (!this.f64457g) {
                do {
                    cVar = this.f64455e;
                    if (cVar.f64433f >= j) {
                        return true;
                    }
                } while (this.f64456f.a(cVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // d.b.c.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() throws IOException {
        a(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!l(i3)) {
                break;
            }
            byte u = this.f64455e.u(i2);
            if ((u < 48 || u > 57) && ((u < 97 || u > 102) && (u < 65 || u > 70))) {
                break;
            }
            i2 = i3;
        }
        return this.f64455e.m();
    }

    @Override // d.b.c.a.a.e
    public String p() throws IOException {
        return e(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f64455e;
        if (cVar.f64433f == 0 && this.f64456f.a(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f64455e.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.f64456f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.b.c.a.a.e
    public com.bytedance.sdk.a.a.f c(long j) throws IOException {
        a(j);
        return this.f64455e.c(j);
    }

    @Override // d.b.c.a.a.e
    public InputStream f() {
        return new a();
    }

    @Override // d.b.c.a.a.e
    public boolean j(long j, com.bytedance.sdk.a.a.f fVar) throws IOException {
        return d(j, fVar, 0, fVar.g());
    }

    @Override // d.b.c.a.a.e
    public long k(byte b2) throws IOException {
        return c(b2, 0L, Long.MAX_VALUE);
    }

    public long c(byte b2, long j, long j2) throws IOException {
        if (this.f64457g) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long e2 = this.f64455e.e(b2, j, j2);
            if (e2 == -1) {
                c cVar = this.f64455e;
                long j3 = cVar.f64433f;
                if (j3 >= j2 || this.f64456f.a(cVar, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return e2;
            }
        }
        return -1L;
    }

    @Override // d.b.c.a.a.e
    public String e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long c2 = c((byte) 10, 0L, j2);
            if (c2 != -1) {
                return this.f64455e.F(c2);
            }
            if (j2 < Long.MAX_VALUE && l(j2) && this.f64455e.u(j2 - 1) == 13 && l(1 + j2) && this.f64455e.u(j2) == 10) {
                return this.f64455e.F(j2);
            }
            c cVar = new c();
            c cVar2 = this.f64455e;
            cVar2.n(cVar, 0L, Math.min(32L, cVar2.v()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f64455e.v(), j) + " content=" + cVar.I().e() + Typography.ellipsis);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // d.b.c.a.a.e
    public short i() throws IOException {
        a(2L);
        return this.f64455e.i();
    }

    /* loaded from: classes5.dex */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            m mVar = m.this;
            if (!mVar.f64457g) {
                return (int) Math.min(mVar.f64455e.f64433f, 2147483647L);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            m.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            m mVar = m.this;
            if (!mVar.f64457g) {
                c cVar = mVar.f64455e;
                if (cVar.f64433f == 0 && mVar.f64456f.a(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f64455e.h() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return m.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!m.this.f64457g) {
                s.c(bArr.length, i2, i3);
                m mVar = m.this;
                c cVar = mVar.f64455e;
                if (cVar.f64433f == 0 && mVar.f64456f.a(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f64455e.d(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // d.b.c.a.a.e
    public int l() throws IOException {
        a(4L);
        return this.f64455e.l();
    }

    @Override // d.b.c.a.a.e
    public void a(long j) throws IOException {
        if (!l(j)) {
            throw new EOFException();
        }
    }

    @Override // d.b.c.a.a.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.f64455e.a(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.f64455e;
                long j = cVar.f64433f;
                if (j > 0) {
                    int d2 = cVar.d(bArr, i2, (int) j);
                    if (d2 == -1) {
                        throw new AssertionError();
                    }
                    i2 += d2;
                } else {
                    throw e2;
                }
            }
        }
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f64456f.a();
    }
}
