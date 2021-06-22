package h.o.d;
/* loaded from: classes8.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f72020e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f72021f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f72022g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f72020e = bVar;
        this.f72021f = bVar2;
        this.f72022g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f72022g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f72021f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f72020e.call(t);
    }
}
