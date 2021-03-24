package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f67919e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f67920f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f67921g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f67919e = bVar;
        this.f67920f = bVar2;
        this.f67921g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67921g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67920f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67919e.call(t);
    }
}
