package com.sdk.base.framework.a.c;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f39235a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39236b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f39237c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f39237c.f39262a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f39237c = null;
        } else if (!(t instanceof k)) {
            this.f39237c = new k<>(b.f39238a, t);
        } else {
            this.f39237c = (k) t;
            this.f39236b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f39237c;
        if (r0 == 0) {
            return null;
        }
        return this.f39236b ? r0 : (T) r0.f39263b;
    }
}
