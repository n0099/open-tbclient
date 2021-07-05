package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final b f40246a;

    /* renamed from: b  reason: collision with root package name */
    public final l f40247b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40248c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f40246a = bVar;
        this.f40247b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = mVar.b(this.f40246a, 2048L);
            if (b2 == -1) {
                return j;
            }
            j += b2;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.f40246a.e();
        if (e2 > 0) {
            this.f40247b.a(this.f40246a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        this.f40246a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.f40246a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        this.f40246a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        this.f40246a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        this.f40246a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        this.f40246a.c(bArr, i2, i3);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.f40248c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f40246a.f40233b > 0) {
                this.f40247b.a(this.f40246a, this.f40246a.f40233b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f40247b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f40248c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j) throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        this.f40246a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f40248c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.f40246a;
        long j = bVar.f40233b;
        if (j > 0) {
            this.f40247b.a(bVar, j);
        }
        this.f40247b.flush();
    }

    public String toString() {
        return "buffer(" + this.f40247b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
