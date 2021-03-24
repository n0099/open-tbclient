package h.o.a;

import rx.internal.operators.OnSubscribeAmb$Selection;
/* loaded from: classes7.dex */
public final class c<T> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.j<? super T> f67705e;

    /* renamed from: f  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f67706f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67707g;

    public final boolean b() {
        if (this.f67707g) {
            return true;
        }
        if (this.f67706f.get() == this) {
            this.f67707g = true;
            return true;
        } else if (this.f67706f.compareAndSet(null, this)) {
            this.f67706f.unsubscribeOthers(this);
            this.f67707g = true;
            return true;
        } else {
            this.f67706f.unsubscribeLosers();
            return false;
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (b()) {
            this.f67705e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (b()) {
            this.f67705e.onError(th);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (b()) {
            this.f67705e.onNext(t);
        }
    }
}
