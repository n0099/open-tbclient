package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes7.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f68716e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f68717f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68718g;

    public final boolean b() {
        if (this.f68718g) {
            return true;
        }
        if (this.f68717f.get() == this) {
            this.f68718g = true;
            return true;
        } else if (this.f68717f.compareAndSet(null, this)) {
            this.f68717f.unsubscribeOthers(this);
            this.f68718g = true;
            return true;
        } else {
            this.f68717f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f68716e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f68716e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f68716e.onNext(t);
        }
    }
}
