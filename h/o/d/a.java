package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f68617e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f68618f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f68619g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f68617e = bVar;
        this.f68618f = bVar2;
        this.f68619g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f68619g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68618f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68617e.call(t);
    }
}
