package h.o.d;

import h.j;
/* loaded from: classes8.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f71919e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f71920f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f71921g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f71919e = bVar;
        this.f71920f = bVar2;
        this.f71921g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f71921g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f71920f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f71919e.call(t);
    }
}
