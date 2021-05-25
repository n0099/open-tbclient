package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f68660e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f68661f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f68662g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f68660e = bVar;
        this.f68661f = bVar2;
        this.f68662g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f68662g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68661f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68660e.call(t);
    }
}
