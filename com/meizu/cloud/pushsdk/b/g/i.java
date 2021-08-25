package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f74494a;

    /* renamed from: b  reason: collision with root package name */
    public final m f74495b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74496c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f74494a = bVar;
        this.f74495b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j2) throws IOException {
        if (bVar != null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f74496c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.f74494a;
                if (bVar2.f74478b == 0 && this.f74495b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f74494a.b(bVar, Math.min(j2, this.f74494a.f74478b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f74496c) {
            return;
        }
        this.f74496c = true;
        this.f74495b.close();
        this.f74494a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f74496c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f74494a.f74478b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f74496c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.f74494a;
                if (bVar.f74478b == 0 && iVar.f74495b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f74494a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (i.this.f74496c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i2, i3);
                i iVar = i.this;
                b bVar = iVar.f74494a;
                if (bVar.f74478b == 0 && iVar.f74495b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f74494a.a(bArr, i2, i3);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f74494a.a(this.f74495b);
        return this.f74494a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f74494a.a(this.f74495b);
        return this.f74494a.i();
    }

    public String toString() {
        return "buffer(" + this.f74495b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
