package com.meizu.cloud.pushsdk.a.h;

import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class e implements k {
    private final k a;

    public e(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = kVar;
    }

    @Override // com.meizu.cloud.pushsdk.a.h.k
    public void a(a aVar, long j) throws IOException {
        this.a.a(aVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.a.h.k, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    @Override // com.meizu.cloud.pushsdk.a.h.k, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.a.h.l
    public void close() throws IOException {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
