package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final b f37981a;

    /* renamed from: b  reason: collision with root package name */
    public final l f37982b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37983c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f37981a = bVar;
        this.f37982b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = mVar.b(this.f37981a, 2048L);
            if (b2 == -1) {
                return j;
            }
            j += b2;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.f37981a.e();
        if (e2 > 0) {
            this.f37982b.a(this.f37981a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        this.f37981a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.f37981a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        this.f37981a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        this.f37981a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        this.f37981a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        this.f37981a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.f37983c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f37981a.f37968b > 0) {
                this.f37982b.a(this.f37981a, this.f37981a.f37968b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f37982b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f37983c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j) throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        this.f37981a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f37983c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.f37981a;
        long j = bVar.f37968b;
        if (j > 0) {
            this.f37982b.a(bVar, j);
        }
        this.f37982b.flush();
    }

    public String toString() {
        return "buffer(" + this.f37982b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
