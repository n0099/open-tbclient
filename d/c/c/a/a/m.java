package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
/* loaded from: classes4.dex */
public final class m implements e {

    /* renamed from: e  reason: collision with root package name */
    public final c f65150e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final q f65151f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65152g;

    public m(q qVar) {
        if (qVar != null) {
            this.f65151f = qVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // d.c.c.a.a.q
    public long a(c cVar, long j) throws IOException {
        if (cVar != null) {
            if (j >= 0) {
                if (!this.f65152g) {
                    c cVar2 = this.f65150e;
                    if (cVar2.f65129f == 0 && this.f65151f.a(cVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f65150e.a(cVar, Math.min(j, this.f65150e.f65129f));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // d.c.c.a.a.e
    public c c() {
        return this.f65150e;
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f65152g) {
            return;
        }
        this.f65152g = true;
        this.f65151f.close();
        this.f65150e.L();
    }

    public boolean d(long j, com.bytedance.sdk.a.a.f fVar, int i, int i2) throws IOException {
        if (!this.f65152g) {
            if (j < 0 || i < 0 || i2 < 0 || fVar.g() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!l(1 + j2) || this.f65150e.u(j2) != fVar.a(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // d.c.c.a.a.e
    public boolean e() throws IOException {
        if (this.f65152g) {
            throw new IllegalStateException("closed");
        }
        return this.f65150e.e() && this.f65151f.a(this.f65150e, 8192L) == -1;
    }

    @Override // d.c.c.a.a.e
    public byte[] f(long j) throws IOException {
        a(j);
        return this.f65150e.f(j);
    }

    @Override // d.c.c.a.a.e
    public void g(long j) throws IOException {
        if (this.f65152g) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f65150e;
            if (cVar.f65129f == 0 && this.f65151f.a(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f65150e.v());
            this.f65150e.g(min);
            j -= min;
        }
    }

    @Override // d.c.c.a.a.e
    public byte h() throws IOException {
        a(1L);
        return this.f65150e.h();
    }

    @Override // d.c.c.a.a.e
    public String i(Charset charset) throws IOException {
        if (charset != null) {
            this.f65150e.l(this.f65151f);
            return this.f65150e.i(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f65152g;
    }

    @Override // d.c.c.a.a.e
    public int j() throws IOException {
        a(4L);
        return this.f65150e.j();
    }

    @Override // d.c.c.a.a.e
    public short k() throws IOException {
        a(2L);
        return this.f65150e.k();
    }

    public boolean l(long j) throws IOException {
        c cVar;
        if (j >= 0) {
            if (!this.f65152g) {
                do {
                    cVar = this.f65150e;
                    if (cVar.f65129f >= j) {
                        return true;
                    }
                } while (this.f65151f.a(cVar, 8192L) != -1);
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
    @Override // d.c.c.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() throws IOException {
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!l(i2)) {
                break;
            }
            byte u = this.f65150e.u(i);
            if ((u < 48 || u > 57) && ((u < 97 || u > 102) && (u < 65 || u > 70))) {
                break;
            }
            i = i2;
        }
        return this.f65150e.m();
    }

    @Override // d.c.c.a.a.e
    public String p() throws IOException {
        return e(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f65150e;
        if (cVar.f65129f == 0 && this.f65151f.a(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f65150e.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.f65151f + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // d.c.c.a.a.e
    public com.bytedance.sdk.a.a.f c(long j) throws IOException {
        a(j);
        return this.f65150e.c(j);
    }

    @Override // d.c.c.a.a.e
    public InputStream f() {
        return new a();
    }

    @Override // d.c.c.a.a.e
    public boolean j(long j, com.bytedance.sdk.a.a.f fVar) throws IOException {
        return d(j, fVar, 0, fVar.g());
    }

    @Override // d.c.c.a.a.e
    public long k(byte b2) throws IOException {
        return c(b2, 0L, Long.MAX_VALUE);
    }

    public long c(byte b2, long j, long j2) throws IOException {
        if (this.f65152g) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long e2 = this.f65150e.e(b2, j, j2);
            if (e2 == -1) {
                c cVar = this.f65150e;
                long j3 = cVar.f65129f;
                if (j3 >= j2 || this.f65151f.a(cVar, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return e2;
            }
        }
        return -1L;
    }

    @Override // d.c.c.a.a.e
    public String e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long c2 = c((byte) 10, 0L, j2);
            if (c2 != -1) {
                return this.f65150e.F(c2);
            }
            if (j2 < Long.MAX_VALUE && l(j2) && this.f65150e.u(j2 - 1) == 13 && l(1 + j2) && this.f65150e.u(j2) == 10) {
                return this.f65150e.F(j2);
            }
            c cVar = new c();
            c cVar2 = this.f65150e;
            cVar2.n(cVar, 0L, Math.min(32L, cVar2.v()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f65150e.v(), j) + " content=" + cVar.I().e() + Typography.ellipsis);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // d.c.c.a.a.e
    public short i() throws IOException {
        a(2L);
        return this.f65150e.i();
    }

    /* loaded from: classes4.dex */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            m mVar = m.this;
            if (!mVar.f65152g) {
                return (int) Math.min(mVar.f65150e.f65129f, 2147483647L);
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
            if (!mVar.f65152g) {
                c cVar = mVar.f65150e;
                if (cVar.f65129f == 0 && mVar.f65151f.a(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f65150e.h() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return m.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!m.this.f65152g) {
                s.c(bArr.length, i, i2);
                m mVar = m.this;
                c cVar = mVar.f65150e;
                if (cVar.f65129f == 0 && mVar.f65151f.a(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f65150e.d(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // d.c.c.a.a.e
    public int l() throws IOException {
        a(4L);
        return this.f65150e.l();
    }

    @Override // d.c.c.a.a.e
    public void a(long j) throws IOException {
        if (!l(j)) {
            throw new EOFException();
        }
    }

    @Override // d.c.c.a.a.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.f65150e.a(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (true) {
                c cVar = this.f65150e;
                long j = cVar.f65129f;
                if (j <= 0) {
                    throw e2;
                }
                int d2 = cVar.d(bArr, i, (int) j);
                if (d2 == -1) {
                    throw new AssertionError();
                }
                i += d2;
            }
        }
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65151f.a();
    }
}
