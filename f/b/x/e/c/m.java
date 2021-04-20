package f.b.x.e.c;
/* loaded from: classes7.dex */
public final class m<T, U, V> extends f.b.z.b<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final l f68518f;

    /* renamed from: g  reason: collision with root package name */
    public final long f68519g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68520h;

    public m(l lVar, long j) {
        this.f68518f = lVar;
        this.f68519g = j;
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.f68520h) {
            return;
        }
        this.f68520h = true;
        this.f68518f.timeout(this.f68519g);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.f68520h) {
            f.b.a0.a.f(th);
            return;
        }
        this.f68520h = true;
        this.f68518f.innerError(th);
    }

    @Override // f.b.o
    public void onNext(Object obj) {
        if (this.f68520h) {
            return;
        }
        this.f68520h = true;
        dispose();
        this.f68518f.timeout(this.f68519g);
    }
}
