package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class d<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67927e;

    public d(h.e<? super T> eVar) {
        this.f67927e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67927e.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67927e.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67927e.onNext(t);
    }
}
