package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
/* loaded from: classes5.dex */
final class g implements b {
    public final a a;
    public final k b;
    private boolean c;

    public g(k kVar) {
        this(kVar, new a());
    }

    public g(k kVar, a aVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = aVar;
        this.b = kVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public long a(l lVar) throws IOException {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = lVar.b(this.a, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public b a() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long e = this.a.e();
        if (e > 0) {
            this.b.a(this.a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.k
    public void a(a aVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(aVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public a b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public b b(d dVar) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(dVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public b b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public b c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public b c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.k, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.l
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.a.b > 0) {
                this.b.a(this.a, this.a.b);
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
            n.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.b
    public b e(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.k, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a(this.a, this.a.b);
        }
        this.b.flush();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
