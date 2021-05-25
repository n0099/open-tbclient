package com.sdk.base.framework.a.c;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f35556a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35557b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f35558c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f35558c.f35583a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f35558c = null;
        } else if (!(t instanceof k)) {
            this.f35558c = new k<>(b.f35559a, t);
        } else {
            this.f35558c = (k) t;
            this.f35557b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f35558c;
        if (r0 == 0) {
            return null;
        }
        return this.f35557b ? r0 : (T) r0.f35584b;
    }
}
