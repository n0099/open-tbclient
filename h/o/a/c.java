package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes8.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f71700e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f71701f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71702g;

    public final boolean b() {
        if (this.f71702g) {
            return true;
        }
        if (this.f71701f.get() == this) {
            this.f71702g = true;
            return true;
        } else if (this.f71701f.compareAndSet(null, this)) {
            this.f71701f.unsubscribeOthers(this);
            this.f71702g = true;
            return true;
        } else {
            this.f71701f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f71700e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f71700e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f71700e.onNext(t);
        }
    }
}
