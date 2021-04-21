package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes7.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f68863e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f68864f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68865g;

    public final boolean b() {
        if (this.f68865g) {
            return true;
        }
        if (this.f68864f.get() == this) {
            this.f68865g = true;
            return true;
        } else if (this.f68864f.compareAndSet(null, this)) {
            this.f68864f.unsubscribeOthers(this);
            this.f68865g = true;
            return true;
        } else {
            this.f68864f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f68863e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f68863e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f68863e.onNext(t);
        }
    }
}
