package com.sdk.base.framework.a;
/* loaded from: classes15.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f13104a;

    /* renamed from: b  reason: collision with root package name */
    private T f13105b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.f13104a = i;
        this.f13105b = t;
        this.c = z;
    }

    public final int a() {
        return this.f13104a;
    }

    public final T b() {
        return this.f13105b;
    }

    public final String toString() {
        return "{code:" + this.f13104a + ", response:" + this.f13105b + ", resultFormCache:" + this.c + "}";
    }
}
