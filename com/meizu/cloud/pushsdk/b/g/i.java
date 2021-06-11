package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f38388a;

    /* renamed from: b  reason: collision with root package name */
    public final m f38389b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38390c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f38388a = bVar;
        this.f38389b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f38390c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.f38388a;
                if (bVar2.f38372b == 0 && this.f38389b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f38388a.b(bVar, Math.min(j, this.f38388a.f38372b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f38390c) {
            return;
        }
        this.f38390c = true;
        this.f38389b.close();
        this.f38388a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f38390c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f38388a.f38372b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f38390c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.f38388a;
                if (bVar.f38372b == 0 && iVar.f38389b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f38388a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (i.this.f38390c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i2, i3);
                i iVar = i.this;
                b bVar = iVar.f38388a;
                if (bVar.f38372b == 0 && iVar.f38389b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f38388a.a(bArr, i2, i3);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f38388a.a(this.f38389b);
        return this.f38388a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f38388a.a(this.f38389b);
        return this.f38388a.i();
    }

    public String toString() {
        return "buffer(" + this.f38389b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
