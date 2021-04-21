package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class d<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f69084e;

    public d(h.e<? super T> eVar) {
        this.f69084e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f69084e.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f69084e.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f69084e.onNext(t);
    }
}
