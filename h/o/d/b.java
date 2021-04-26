package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f67940e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f67941f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f67942g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f67940e = bVar;
        this.f67941f = bVar2;
        this.f67942g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67942g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67941f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67940e.call(t);
    }
}
