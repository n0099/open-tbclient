package com.sdk.base.framework.a;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f38799a;

    /* renamed from: b  reason: collision with root package name */
    public long f38800b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f38799a = 1500L;
        this.f38799a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f38800b > this.f38799a;
    }
}
