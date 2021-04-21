package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f37984a;

    /* renamed from: b  reason: collision with root package name */
    public final m f37985b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37986c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f37984a = bVar;
        this.f37985b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f37986c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.f37984a;
                if (bVar2.f37968b == 0 && this.f37985b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f37984a.b(bVar, Math.min(j, this.f37984a.f37968b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f37986c) {
            return;
        }
        this.f37986c = true;
        this.f37985b.close();
        this.f37984a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f37986c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f37984a.f37968b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f37986c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.f37984a;
                if (bVar.f37968b == 0 && iVar.f37985b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f37984a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (i.this.f37986c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i, i2);
                i iVar = i.this;
                b bVar = iVar.f37984a;
                if (bVar.f37968b == 0 && iVar.f37985b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f37984a.a(bArr, i, i2);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f37984a.a(this.f37985b);
        return this.f37984a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f37984a.a(this.f37985b);
        return this.f37984a.i();
    }

    public String toString() {
        return "buffer(" + this.f37985b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
