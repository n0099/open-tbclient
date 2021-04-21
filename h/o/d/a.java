package h.o.d;
/* loaded from: classes7.dex */
public final class a<T> implements h.e<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.b<? super T> f69078e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super Throwable> f69079f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.a f69080g;

    public a(h.n.b<? super T> bVar, h.n.b<? super Throwable> bVar2, h.n.a aVar) {
        this.f69078e = bVar;
        this.f69079f = bVar2;
        this.f69080g = aVar;
    }

    @Override // h.e
    public void onCompleted() {
        this.f69080g.call();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f69079f.call(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f69078e.call(t);
    }
}
