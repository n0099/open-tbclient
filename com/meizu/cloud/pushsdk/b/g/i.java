package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    public final b f37889a;

    /* renamed from: b  reason: collision with root package name */
    public final m f37890b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37891c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f37889a = bVar;
        this.f37890b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f37891c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.f37889a;
                if (bVar2.f37873b == 0 && this.f37890b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.f37889a.b(bVar, Math.min(j, this.f37889a.f37873b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f37891c) {
            return;
        }
        this.f37891c = true;
        this.f37890b.close();
        this.f37889a.j();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f37891c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f37889a.f37873b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f37891c) {
                    throw new IOException("closed");
                }
                i iVar = i.this;
                b bVar = iVar.f37889a;
                if (bVar.f37873b == 0 && iVar.f37890b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f37889a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (i.this.f37891c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i, i2);
                i iVar = i.this;
                b bVar = iVar.f37889a;
                if (bVar.f37873b == 0 && iVar.f37890b.b(bVar, 2048L) == -1) {
                    return -1;
                }
                return i.this.f37889a.a(bArr, i, i2);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() throws IOException {
        this.f37889a.a(this.f37890b);
        return this.f37889a.h();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() throws IOException {
        this.f37889a.a(this.f37890b);
        return this.f37889a.i();
    }

    public String toString() {
        return "buffer(" + this.f37890b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
