package com.sdk.base.framework.a.c;
/* loaded from: classes15.dex */
final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    a<T> f13073a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13074b = false;
    private k<?> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.c.f13087a;
    }

    public final void a(T t) {
        if (t == null) {
            this.c = null;
        } else if (!(t instanceof k)) {
            this.c = new k<>(b.f13075a, t);
        } else {
            this.c = (k) t;
            this.f13074b = true;
        }
    }

    public final T b() {
        if (this.c == null) {
            return null;
        }
        return this.f13074b ? (T) this.c : (T) this.c.f13088b;
    }
}
