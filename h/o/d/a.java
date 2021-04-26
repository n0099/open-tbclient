package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f67937e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f67938f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f67939g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f67937e = bVar;
        this.f67938f = bVar2;
        this.f67939g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f67939g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f67938f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f67937e.call(t);
    }
}
