package com.sdk.base.framework.a;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f38415a;

    /* renamed from: b  reason: collision with root package name */
    public long f38416b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f38415a = 1500L;
        this.f38415a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f38416b > this.f38415a;
    }
}
