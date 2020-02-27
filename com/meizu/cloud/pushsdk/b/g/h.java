package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
final class h implements c {
    public final a a;
    public final l b;
    private boolean c;

    public h(l lVar) {
        this(lVar, new a());
    }

    public h(l lVar, a aVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = aVar;
        this.b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public long b(a aVar, long j) throws IOException {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b == 0 && this.b.b(this.a, 2048L) == -1) {
            return -1L;
        }
        return this.a.b(aVar, Math.min(j, this.a.b));
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.h.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (h.this.c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(h.this.a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                h.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (h.this.c) {
                    throw new IOException("closed");
                }
                if (h.this.a.b == 0 && h.this.b.b(h.this.a, 2048L) == -1) {
                    return -1;
                }
                return h.this.a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (h.this.c) {
                    throw new IOException("closed");
                }
                n.a(bArr.length, i, i2);
                if (h.this.a.b == 0 && h.this.b.b(h.this.a, 2048L) == -1) {
                    return -1;
                }
                return h.this.a.a(bArr, i, i2);
            }

            public String toString() {
                return h.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public String h() throws IOException {
        this.a.a(this.b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public byte[] i() throws IOException {
        this.a.a(this.b);
        return this.a.i();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
