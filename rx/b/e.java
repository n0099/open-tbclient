package rx.b;

import rx.j;
/* loaded from: classes14.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qtC;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qtC = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qtC.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qtC.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qtC.onNext(t);
    }
}
