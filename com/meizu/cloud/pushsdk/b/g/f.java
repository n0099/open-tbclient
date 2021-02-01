package com.meizu.cloud.pushsdk.b.g;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class f implements l {

    /* renamed from: a  reason: collision with root package name */
    private final l f11199a;

    public f(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11199a = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        this.f11199a.a(bVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        this.f11199a.close();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        this.f11199a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f11199a.toString() + ")";
    }
}
