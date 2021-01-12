package com.sdk.base.framework.a;
/* loaded from: classes14.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private long f12772a;

    /* renamed from: b  reason: collision with root package name */
    private long f12773b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f12772a = 1500L;
        this.f12772a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f12773b > this.f12772a;
    }
}
