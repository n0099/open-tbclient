package com.sdk.base.framework.a;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f39331a;

    /* renamed from: b  reason: collision with root package name */
    public long f39332b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f39331a = 1500L;
        this.f39331a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f39332b > this.f39331a;
    }
}
