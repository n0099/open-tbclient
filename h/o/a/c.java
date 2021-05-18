package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes7.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f68401e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f68402f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68403g;

    public final boolean b() {
        if (this.f68403g) {
            return true;
        }
        if (this.f68402f.get() == this) {
            this.f68403g = true;
            return true;
        } else if (this.f68402f.compareAndSet(null, this)) {
            this.f68402f.unsubscribeOthers(this);
            this.f68403g = true;
            return true;
        } else {
            this.f68402f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f68401e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f68401e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f68401e.onNext(t);
        }
    }
}
