package com.sdk.base.framework.a;
/* loaded from: classes5.dex */
final class c {
    private long a;
    private long b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.a = 1500L;
        this.a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.b > this.a;
    }
}
