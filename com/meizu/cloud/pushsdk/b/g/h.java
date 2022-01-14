package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class h implements c {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final l f58609b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58610c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = bVar;
        this.f58609b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long b2 = mVar.b(this.a, 2048L);
            if (b2 == -1) {
                return j2;
            }
            j2 += b2;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.a.e();
        if (e2 > 0) {
            this.f58609b.a(this.a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j2) throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(bVar, j2);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr, i2, i3);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.f58610c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.a.f58602b > 0) {
                this.f58609b.a(this.a, this.a.f58602b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f58609b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f58610c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j2) throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        this.a.e(j2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f58610c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.a;
        long j2 = bVar.f58602b;
        if (j2 > 0) {
            this.f58609b.a(bVar, j2);
        }
        this.f58609b.flush();
    }

    public String toString() {
        return "buffer(" + this.f58609b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
