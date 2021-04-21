package h.o.d;

import h.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f69081e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<Throwable> f69082f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f69083g;

    public b(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2, h.n.a aVar) {
        this.f69081e = bVar;
        this.f69082f = bVar2;
        this.f69083g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f69083g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f69082f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f69081e.call(t);
    }
}
