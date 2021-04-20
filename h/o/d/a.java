package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f68931e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f68932f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f68933g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f68931e = bVar;
        this.f68932f = bVar2;
        this.f68933g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f68933g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68932f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68931e.call(t);
    }
}
