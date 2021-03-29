package f.a.x.e.c;
/* loaded from: classes7.dex */
public final class m<T, U, V> extends f.a.z.b<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final l f67512f;

    /* renamed from: g  reason: collision with root package name */
    public final long f67513g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67514h;

    public m(l lVar, long j) {
        this.f67512f = lVar;
        this.f67513g = j;
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.f67514h) {
            return;
        }
        this.f67514h = true;
        this.f67512f.timeout(this.f67513g);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.f67514h) {
            f.a.a0.a.f(th);
            return;
        }
        this.f67514h = true;
        this.f67512f.innerError(th);
    }

    @Override // f.a.o
    public void onNext(Object obj) {
        if (this.f67514h) {
            return;
        }
        this.f67514h = true;
        dispose();
        this.f67512f.timeout(this.f67513g);
    }
}
