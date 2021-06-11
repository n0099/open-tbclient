package h.q;

import h.j;
/* loaded from: classes8.dex */
public class e<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<T> f71984e;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    @Override // h.e
    public void onCompleted() {
        this.f71984e.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f71984e.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f71984e.onNext(t);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.f71984e = new d(jVar);
    }
}
