package h.o.d;

import h.j;
/* loaded from: classes8.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f72023e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f72024f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f72025g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f72023e = bVar;
        this.f72024f = bVar2;
        this.f72025g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f72025g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f72024f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f72023e.call(t);
    }
}
