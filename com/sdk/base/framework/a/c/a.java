package com.sdk.base.framework.a.c;
/* loaded from: classes8.dex */
final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    a<T> f4462a;
    private boolean b = false;
    private k<?> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(T t) {
        a(t);
    }

    public final int a() {
        return this.c.f4470a;
    }

    public final void a(T t) {
        if (t == null) {
            this.c = null;
        } else if (!(t instanceof k)) {
            this.c = new k<>(b.f4463a, t);
        } else {
            this.c = (k) t;
            this.b = true;
        }
    }

    public final T b() {
        if (this.c == null) {
            return null;
        }
        return this.b ? (T) this.c : (T) this.c.b;
    }
}
