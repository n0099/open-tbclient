package com.sdk.base.framework.a;
/* loaded from: classes4.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private long f12774a;

    /* renamed from: b  reason: collision with root package name */
    private long f12775b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f12774a = 1500L;
        this.f12774a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f12775b > this.f12774a;
    }
}
