package com.sdk.base.framework.a;
/* loaded from: classes14.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f12805a;

    /* renamed from: b  reason: collision with root package name */
    private T f12806b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.f12805a = i;
        this.f12806b = t;
        this.c = z;
    }

    public final int a() {
        return this.f12805a;
    }

    public final T b() {
        return this.f12806b;
    }

    public final String toString() {
        return "{code:" + this.f12805a + ", response:" + this.f12806b + ", resultFormCache:" + this.c + "}";
    }
}
