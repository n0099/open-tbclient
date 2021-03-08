package rx.b;

import rx.j;
/* loaded from: classes4.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qEH;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qEH = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qEH.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qEH.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qEH.onNext(t);
    }
}
