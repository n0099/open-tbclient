package f.a.x.e.a;
/* loaded from: classes7.dex */
public final class e<T> implements g.d.d {

    /* renamed from: e  reason: collision with root package name */
    public final g.d.c<? super T> f67482e;

    /* renamed from: f  reason: collision with root package name */
    public final T f67483f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67484g;

    public e(T t, g.d.c<? super T> cVar) {
        this.f67483f = t;
        this.f67482e = cVar;
    }

    @Override // g.d.d
    public void cancel() {
    }

    /* JADX DEBUG: Type inference failed for r5v0. Raw type applied. Possible types: T, ? super T */
    @Override // g.d.d
    public void request(long j) {
        if (j <= 0 || this.f67484g) {
            return;
        }
        this.f67484g = true;
        g.d.c<? super T> cVar = this.f67482e;
        cVar.onNext((T) this.f67483f);
        cVar.onComplete();
    }
}
