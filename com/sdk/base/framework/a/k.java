package com.sdk.base.framework.a;
/* loaded from: classes15.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f13105a;

    /* renamed from: b  reason: collision with root package name */
    private T f13106b;
    private final boolean c;

    public k(int i, T t, boolean z) {
        this.f13105a = i;
        this.f13106b = t;
        this.c = z;
    }

    public final int a() {
        return this.f13105a;
    }

    public final T b() {
        return this.f13106b;
    }

    public final String toString() {
        return "{code:" + this.f13105a + ", response:" + this.f13106b + ", resultFormCache:" + this.c + "}";
    }
}
