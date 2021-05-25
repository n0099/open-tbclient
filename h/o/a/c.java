package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes7.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f68444e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f68445f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68446g;

    public final boolean b() {
        if (this.f68446g) {
            return true;
        }
        if (this.f68445f.get() == this) {
            this.f68446g = true;
            return true;
        } else if (this.f68445f.compareAndSet(null, this)) {
            this.f68445f.unsubscribeOthers(this);
            this.f68446g = true;
            return true;
        } else {
            this.f68445f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f68444e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f68444e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f68444e.onNext(t);
        }
    }
}
