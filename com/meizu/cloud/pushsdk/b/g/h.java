package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final b f37886a;

    /* renamed from: b  reason: collision with root package name */
    public final l f37887b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37888c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f37886a = bVar;
        this.f37887b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = mVar.b(this.f37886a, 2048L);
            if (b2 == -1) {
                return j;
            }
            j += b2;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.f37886a.e();
        if (e2 > 0) {
            this.f37887b.a(this.f37886a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        this.f37886a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this.f37886a;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(e eVar) throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        this.f37886a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c b(String str) throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        this.f37886a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        this.f37886a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        this.f37886a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        if (this.f37888c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f37886a.f37873b > 0) {
                this.f37887b.a(this.f37886a, this.f37886a.f37873b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f37887b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f37888c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public c e(long j) throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        this.f37886a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f37888c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.f37886a;
        long j = bVar.f37873b;
        if (j > 0) {
            this.f37887b.a(bVar, j);
        }
        this.f37887b.flush();
    }

    public String toString() {
        return "buffer(" + this.f37887b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
