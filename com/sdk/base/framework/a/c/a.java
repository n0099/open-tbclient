package com.sdk.base.framework.a.c;
/* loaded from: classes4.dex */
final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    a<T> f12776a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12777b = false;
    private k<?> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.c.f12790a;
    }

    public final void a(T t) {
        if (t == null) {
            this.c = null;
        } else if (!(t instanceof k)) {
            this.c = new k<>(b.f12778a, t);
        } else {
            this.c = (k) t;
            this.f12777b = true;
        }
    }

    public final T b() {
        if (this.c == null) {
            return null;
        }
        return this.f12777b ? (T) this.c : (T) this.c.f12791b;
    }
}
