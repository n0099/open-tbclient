package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f67916e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f67917f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f67918g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f67916e = bVar;
        this.f67917f = bVar2;
        this.f67918g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67918g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67917f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67916e.call(t);
    }
}
