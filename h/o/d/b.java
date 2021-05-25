package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f68663e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f68664f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f68665g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f68663e = bVar;
        this.f68664f = bVar2;
        this.f68665g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f68665g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68664f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68663e.call(t);
    }
}
