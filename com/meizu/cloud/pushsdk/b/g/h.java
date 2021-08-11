package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final b f74291a;

    /* renamed from: b  reason: collision with root package name */
    public final l f74292b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74293c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f74291a = bVar;
        this.f74292b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long b2 = mVar.b(this.f74291a, 2048L);
            if (b2 == -1) {
                return j2;
            }
            j2 += b2;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.f74291a.e();
        if (e2 > 0) {
            this.f74292b.a(this.f74291a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j2) throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        this.f74291a.a(bVar, j2);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.f74291a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        this.f74291a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        this.f74291a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        this.f74291a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        this.f74291a.c(bArr, i2, i3);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.f74293c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f74291a.f74278b > 0) {
                this.f74292b.a(this.f74291a, this.f74291a.f74278b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f74292b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f74293c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j2) throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        this.f74291a.e(j2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f74293c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.f74291a;
        long j2 = bVar.f74278b;
        if (j2 > 0) {
            this.f74292b.a(bVar, j2);
        }
        this.f74292b.flush();
    }

    public String toString() {
        return "buffer(" + this.f74292b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
