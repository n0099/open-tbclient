package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f68620e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f68621f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f68622g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f68620e = bVar;
        this.f68621f = bVar2;
        this.f68622g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f68622g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68621f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68620e.call(t);
    }
}
