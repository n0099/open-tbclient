package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final b f37260a;

    /* renamed from: b  reason: collision with root package name */
    public final l f37261b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37262c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f37260a = bVar;
        this.f37261b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = mVar.b(this.f37260a, 2048L);
            if (b2 == -1) {
                return j;
            }
            j += b2;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.f37260a.e();
        if (e2 > 0) {
            this.f37261b.a(this.f37260a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        this.f37260a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.f37260a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        this.f37260a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        this.f37260a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        this.f37260a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        this.f37260a.c(bArr, i2, i3);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.f37262c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f37260a.f37247b > 0) {
                this.f37261b.a(this.f37260a, this.f37260a.f37247b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f37261b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f37262c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j) throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        this.f37260a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f37262c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.f37260a;
        long j = bVar.f37247b;
        if (j > 0) {
            this.f37261b.a(bVar, j);
        }
        this.f37261b.flush();
    }

    public String toString() {
        return "buffer(" + this.f37261b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
