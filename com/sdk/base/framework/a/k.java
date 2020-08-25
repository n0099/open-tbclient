package com.sdk.base.framework.a;
/* loaded from: classes5.dex */
public final class k<T> {
    private int a;
    private T b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.a = i;
        this.b = t;
        this.c = z;
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final String toString() {
        return "{code:" + this.a + ", response:" + this.b + ", resultFormCache:" + this.c + "}";
    }
}
