package com.sdk.base.framework.a.c;
/* loaded from: classes6.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f38706a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38707b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f38708c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f38708c.f38733a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f38708c = null;
        } else if (!(t instanceof k)) {
            this.f38708c = new k<>(b.f38709a, t);
        } else {
            this.f38708c = (k) t;
            this.f38707b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f38708c;
        if (r0 == 0) {
            return null;
        }
        return this.f38707b ? r0 : (T) r0.f38734b;
    }
}
