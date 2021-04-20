package com.sdk.base.framework.a;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f38704a;

    /* renamed from: b  reason: collision with root package name */
    public long f38705b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f38704a = 1500L;
        this.f38704a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f38705b > this.f38704a;
    }
}
