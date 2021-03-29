package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f67921e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f67922f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f67923g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f67921e = bVar;
        this.f67922f = bVar2;
        this.f67923g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67923g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67922f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67921e.call(t);
    }
}
