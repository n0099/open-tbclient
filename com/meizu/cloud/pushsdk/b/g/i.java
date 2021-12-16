package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class i implements d {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final m f60918b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60919c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = bVar;
        this.f60918b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j2) throws IOException {
        if (bVar != null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f60919c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.a;
                if (bVar2.f60909b == 0 && this.f60918b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.a.b(bVar, Math.min(j2, this.a.f60909b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f60919c) {
            return;
        }
        this.f60919c = true;
        this.f60918b.close();
        this.a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f60919c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.a.f60909b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f60919c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.a;
                if (bVar.f60909b == 0 && iVar.f60918b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (i.this.f60919c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i2, i3);
                i iVar = i.this;
                b bVar = iVar.a;
                if (bVar.f60909b == 0 && iVar.f60918b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.a.a(bArr, i2, i3);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.a.a(this.f60918b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.a.a(this.f60918b);
        return this.a.i();
    }

    public String toString() {
        return "buffer(" + this.f60918b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
