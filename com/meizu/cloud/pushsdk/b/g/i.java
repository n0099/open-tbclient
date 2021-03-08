package com.meizu.cloud.pushsdk.b.g;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f7369a;
    public final m b;
    private boolean c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f7369a = bVar;
        this.b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.f7369a.b == 0 && this.b.b(this.f7369a, 2048L) == -1) {
            return -1L;
        }
        return this.f7369a.b(bVar, Math.min(j, this.f7369a.b));
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.f7369a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.c) {
                    throw new IOException(LogConfig.TYPE_CLOSED);
                }
                return (int) Math.min(i.this.f7369a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.c) {
                    throw new IOException(LogConfig.TYPE_CLOSED);
                }
                if (i.this.f7369a.b == 0 && i.this.b.b(i.this.f7369a, 2048L) == -1) {
                    return -1;
                }
                return i.this.f7369a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (i.this.c) {
                    throw new IOException(LogConfig.TYPE_CLOSED);
                }
                o.a(bArr.length, i, i2);
                if (i.this.f7369a.b == 0 && i.this.b.b(i.this.f7369a, 2048L) == -1) {
                    return -1;
                }
                return i.this.f7369a.a(bArr, i, i2);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f7369a.a(this.b);
        return this.f7369a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f7369a.a(this.b);
        return this.f7369a.i();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
