package com.sdk.base.framework.a.c;
/* loaded from: classes15.dex */
final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    a<T> f13074a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13075b = false;
    private k<?> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.c.f13088a;
    }

    public final void a(T t) {
        if (t == null) {
            this.c = null;
        } else if (!(t instanceof k)) {
            this.c = new k<>(b.f13076a, t);
        } else {
            this.c = (k) t;
            this.f13075b = true;
        }
    }

    public final T b() {
        if (this.c == null) {
            return null;
        }
        return this.f13075b ? (T) this.c : (T) this.c.f13089b;
    }
}
