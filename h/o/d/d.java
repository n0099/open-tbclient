package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class d<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67922e;

    public d(h.e<? super T> eVar) {
        this.f67922e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67922e.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67922e.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67922e.onNext(t);
    }
}
