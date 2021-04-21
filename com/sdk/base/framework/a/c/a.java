package com.sdk.base.framework.a.c;
/* loaded from: classes6.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f38801a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38802b = false;

    /* renamed from: c  reason: collision with root package name */
    public k<?> f38803c;

    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.f38803c.f38828a;
    }

    public final void a(T t) {
        if (t == null) {
            this.f38803c = null;
        } else if (!(t instanceof k)) {
            this.f38803c = new k<>(b.f38804a, t);
        } else {
            this.f38803c = (k) t;
            this.f38802b = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.sdk.base.framework.a.c.k<?>, com.sdk.base.framework.a.c.k] */
    public final T b() {
        ?? r0 = (T) this.f38803c;
        if (r0 == 0) {
            return null;
        }
        return this.f38802b ? r0 : (T) r0.f38829b;
    }
}
