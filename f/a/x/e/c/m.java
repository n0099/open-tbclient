package f.a.x.e.c;
/* loaded from: classes7.dex */
public final class m<T, U, V> extends f.a.z.b<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final l f67507f;

    /* renamed from: g  reason: collision with root package name */
    public final long f67508g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67509h;

    public m(l lVar, long j) {
        this.f67507f = lVar;
        this.f67508g = j;
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.f67509h) {
            return;
        }
        this.f67509h = true;
        this.f67507f.timeout(this.f67508g);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.f67509h) {
            f.a.a0.a.f(th);
            return;
        }
        this.f67509h = true;
        this.f67507f.innerError(th);
    }

    @Override // f.a.o
    public void onNext(Object obj) {
        if (this.f67509h) {
            return;
        }
        this.f67509h = true;
        dispose();
        this.f67507f.timeout(this.f67508g);
    }
}
