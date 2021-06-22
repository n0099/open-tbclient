package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes8.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f71804e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f71805f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71806g;

    public final boolean b() {
        if (this.f71806g) {
            return true;
        }
        if (this.f71805f.get() == this) {
            this.f71806g = true;
            return true;
        } else if (this.f71805f.compareAndSet(null, this)) {
            this.f71805f.unsubscribeOthers(this);
            this.f71806g = true;
            return true;
        } else {
            this.f71805f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f71804e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f71804e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f71804e.onNext(t);
        }
    }
}
