package com.sdk.base.framework.a.c;
/* loaded from: classes6.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f38417a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38418b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f38419c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f38419c.f38444a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f38419c = null;
        } else if (!(t instanceof k)) {
            this.f38419c = new k<>(b.f38420a, t);
        } else {
            this.f38419c = (k) t;
            this.f38418b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f38419c;
        if (r0 == 0) {
            return null;
        }
        return this.f38418b ? r0 : (T) r0.f38445b;
    }
}
