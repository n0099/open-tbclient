package com.sdk.base.framework.a.c;
/* loaded from: classes6.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f36382a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36383b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f36384c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f36384c.f36409a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f36384c = null;
        } else if (!(t instanceof k)) {
            this.f36384c = new k<>(b.f36385a, t);
        } else {
            this.f36384c = (k) t;
            this.f36383b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f36384c;
        if (r0 == 0) {
            return null;
        }
        return this.f36383b ? r0 : (T) r0.f36410b;
    }
}
