package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
/* loaded from: classes15.dex */
final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final b f4354a;
    public final l b;
    private boolean c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f4354a = bVar;
        this.b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = mVar.b(this.f4354a, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public c a() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long e = this.f4354a.e();
        if (e > 0) {
            this.b.a(this.f4354a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4354a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.f4354a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4354a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4354a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4354a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4354a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f4354a.b > 0) {
                this.b.a(this.f4354a, this.f4354a.b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4354a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.f4354a.b > 0) {
            this.b.a(this.f4354a, this.f4354a.b);
        }
        this.b.flush();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
