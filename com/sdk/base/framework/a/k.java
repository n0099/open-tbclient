package com.sdk.base.framework.a;
/* loaded from: classes4.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f7623a;
    private T b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.f7623a = i;
        this.b = t;
        this.c = z;
    }

    public final int a() {
        return this.f7623a;
    }

    public final T b() {
        return this.b;
    }

    public final String toString() {
        return "{code:" + this.f7623a + ", response:" + this.b + ", resultFormCache:" + this.c + "}";
    }
}
