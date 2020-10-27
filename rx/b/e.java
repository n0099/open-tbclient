package rx.b;

import rx.j;
/* loaded from: classes16.dex */
public class e<T> extends j<T> {
    private final rx.e<T> pZU;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.pZU = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pZU.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pZU.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pZU.onNext(t);
    }
}
