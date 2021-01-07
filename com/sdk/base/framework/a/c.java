package com.sdk.base.framework.a;
/* loaded from: classes15.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private long f13072a;

    /* renamed from: b  reason: collision with root package name */
    private long f13073b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f13072a = 1500L;
        this.f13072a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f13073b > this.f13072a;
    }
}
