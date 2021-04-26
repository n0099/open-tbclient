package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f35535a;

    /* renamed from: b  reason: collision with root package name */
    public final m f35536b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35537c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f35535a = bVar;
        this.f35536b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f35537c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.f35535a;
                if (bVar2.f35519b == 0 && this.f35536b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f35535a.b(bVar, Math.min(j, this.f35535a.f35519b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f35537c) {
            return;
        }
        this.f35537c = true;
        this.f35536b.close();
        this.f35535a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f35537c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f35535a.f35519b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f35537c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.f35535a;
                if (bVar.f35519b == 0 && iVar.f35536b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f35535a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (i.this.f35537c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i2, i3);
                i iVar = i.this;
                b bVar = iVar.f35535a;
                if (bVar.f35519b == 0 && iVar.f35536b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f35535a.a(bArr, i2, i3);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f35535a.a(this.f35536b);
        return this.f35535a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f35535a.a(this.f35536b);
        return this.f35535a.i();
    }

    public String toString() {
        return "buffer(" + this.f35536b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
