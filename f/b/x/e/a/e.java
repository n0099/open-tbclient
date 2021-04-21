package f.b.x.e.a;
/* loaded from: classes7.dex */
public final class e<T> implements g.d.d {

    /* renamed from: e  reason: collision with root package name */
    public final g.d.c<? super T> f68635e;

    /* renamed from: f  reason: collision with root package name */
    public final T f68636f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68637g;

    public e(T t, g.d.c<? super T> cVar) {
        this.f68636f = t;
        this.f68635e = cVar;
    }

    @Override // g.d.d
    public void cancel() {
    }

    /* JADX DEBUG: Type inference failed for r5v0. Raw type applied. Possible types: T, ? super T */
    @Override // g.d.d
    public void request(long j) {
        if (j <= 0 || this.f68637g) {
            return;
        }
        this.f68637g = true;
        g.d.c<? super T> cVar = this.f68635e;
        cVar.onNext((T) this.f68636f);
        cVar.onComplete();
    }
}
