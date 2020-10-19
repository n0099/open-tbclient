package com.sdk.base.framework.a;
/* loaded from: classes16.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f4478a;
    private T b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.f4478a = i;
        this.b = t;
        this.c = z;
    }

    public final int a() {
        return this.f4478a;
    }

    public final T b() {
        return this.b;
    }

    public final String toString() {
        return "{code:" + this.f4478a + ", response:" + this.b + ", resultFormCache:" + this.c + "}";
    }
}
