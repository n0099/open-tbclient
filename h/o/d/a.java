package h.o.d;
/* loaded from: classes8.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f71916e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f71917f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f71918g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f71916e = bVar;
        this.f71917f = bVar2;
        this.f71918g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f71918g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f71917f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f71916e.call(t);
    }
}
