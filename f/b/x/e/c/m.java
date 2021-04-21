package f.b.x.e.c;
/* loaded from: classes7.dex */
public final class m<T, U, V> extends f.b.z.b<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final l f68665f;

    /* renamed from: g  reason: collision with root package name */
    public final long f68666g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68667h;

    public m(l lVar, long j) {
        this.f68665f = lVar;
        this.f68666g = j;
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.f68667h) {
            return;
        }
        this.f68667h = true;
        this.f68665f.timeout(this.f68666g);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.f68667h) {
            f.b.a0.a.f(th);
            return;
        }
        this.f68667h = true;
        this.f68665f.innerError(th);
    }

    @Override // f.b.o
    public void onNext(Object obj) {
        if (this.f68667h) {
            return;
        }
        this.f68667h = true;
        dispose();
        this.f68665f.timeout(this.f68666g);
    }
}
