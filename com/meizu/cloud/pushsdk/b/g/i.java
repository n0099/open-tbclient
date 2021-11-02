package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f67392a;

    /* renamed from: b  reason: collision with root package name */
    public final m f67393b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67394c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f67392a = bVar;
        this.f67393b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f67394c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.f67392a;
                if (bVar2.f67376b == 0 && this.f67393b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f67392a.b(bVar, Math.min(j, this.f67392a.f67376b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f67394c) {
            return;
        }
        this.f67394c = true;
        this.f67393b.close();
        this.f67392a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f67394c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f67392a.f67376b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f67394c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.f67392a;
                if (bVar.f67376b == 0 && iVar.f67393b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f67392a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (i.this.f67394c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i2, i3);
                i iVar = i.this;
                b bVar = iVar.f67392a;
                if (bVar.f67376b == 0 && iVar.f67393b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f67392a.a(bArr, i2, i3);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f67392a.a(this.f67393b);
        return this.f67392a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f67392a.a(this.f67393b);
        return this.f67392a.i();
    }

    public String toString() {
        return "buffer(" + this.f67393b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
