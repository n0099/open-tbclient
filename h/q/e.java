package h.q;

import h.j;
/* loaded from: classes7.dex */
public class e<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<T> f68005e;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    @Override // h.e
    public void onCompleted() {
        this.f68005e.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f68005e.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f68005e.onNext(t);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.f68005e = new d(jVar);
    }
}
