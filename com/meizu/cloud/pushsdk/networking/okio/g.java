package com.meizu.cloud.pushsdk.networking.okio;

import java.io.IOException;
/* loaded from: classes3.dex */
final class g implements c {
    public final b a;
    public final k b;
    private boolean c;

    public g(k kVar, b bVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = bVar;
        this.b = kVar;
    }

    public g(k kVar) {
        this(kVar, new b());
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.k
    public void a(b bVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public c b(ByteString byteString) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(byteString);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public c b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public c c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public long a(l lVar) throws IOException {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = lVar.b(this.a, 2048L);
            if (b != -1) {
                j += b;
                a();
            } else {
                return j;
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public c e(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.e(j);
        return a();
    }

    public c a() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long e = this.a.e();
        if (e > 0) {
            this.b.a(this.a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.k, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a(this.a, this.a.b);
        }
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.k, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.networking.okio.l
    public void close() throws IOException {
        if (!this.c) {
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
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
