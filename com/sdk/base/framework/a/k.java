package com.sdk.base.framework.a;
/* loaded from: classes4.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f12807a;

    /* renamed from: b  reason: collision with root package name */
    private T f12808b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.f12807a = i;
        this.f12808b = t;
        this.c = z;
    }

    public final int a() {
        return this.f12807a;
    }

    public final T b() {
        return this.f12808b;
    }

    public final String toString() {
        return "{code:" + this.f12807a + ", response:" + this.f12808b + ", resultFormCache:" + this.c + "}";
    }
}
