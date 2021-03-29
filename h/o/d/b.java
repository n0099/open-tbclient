package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f67924e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f67925f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f67926g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f67924e = bVar;
        this.f67925f = bVar2;
        this.f67926g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67926g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67925f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67924e.call(t);
    }
}
