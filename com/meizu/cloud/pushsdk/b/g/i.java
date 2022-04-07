package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class i implements d {
    public final b a;
    public final m b;
    public boolean c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = bVar;
        this.b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.a;
                if (bVar2.b == 0 && this.b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.a.b(bVar, Math.min(j, this.a.b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.a;
                if (bVar.b == 0 && iVar.b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (i.this.c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i, i2);
                i iVar = i.this;
                b bVar = iVar.a;
                if (bVar.b == 0 && iVar.b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.a.a(bArr, i, i2);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.a.a(this.b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.a.a(this.b);
        return this.a.i();
    }

    public String toString() {
        return "buffer(" + this.b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
