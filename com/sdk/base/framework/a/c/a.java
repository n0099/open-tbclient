package com.sdk.base.framework.a.c;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f35627a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35628b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f35629c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f35629c.f35654a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f35629c = null;
        } else if (!(t instanceof k)) {
            this.f35629c = new k<>(b.f35630a, t);
        } else {
            this.f35629c = (k) t;
            this.f35628b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f35629c;
        if (r0 == 0) {
            return null;
        }
        return this.f35628b ? r0 : (T) r0.f35655b;
    }
}
