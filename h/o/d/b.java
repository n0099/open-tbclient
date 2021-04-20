package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f68934e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f68935f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f68936g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f68934e = bVar;
        this.f68935f = bVar2;
        this.f68936g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f68936g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68935f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68934e.call(t);
    }
}
