package f.a.x.e.a;
/* loaded from: classes7.dex */
public final class e<T> implements g.d.d {

    /* renamed from: e  reason: collision with root package name */
    public final g.d.c<? super T> f67477e;

    /* renamed from: f  reason: collision with root package name */
    public final T f67478f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67479g;

    public e(T t, g.d.c<? super T> cVar) {
        this.f67478f = t;
        this.f67477e = cVar;
    }

    @Override // g.d.d
    public void cancel() {
    }

    /* JADX DEBUG: Type inference failed for r5v0. Raw type applied. Possible types: T, ? super T */
    @Override // g.d.d
    public void request(long j) {
        if (j <= 0 || this.f67479g) {
            return;
        }
        this.f67479g = true;
        g.d.c<? super T> cVar = this.f67477e;
        cVar.onNext((T) this.f67478f);
        cVar.onComplete();
    }
}
