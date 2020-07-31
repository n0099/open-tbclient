package rx.b;

import rx.j;
/* loaded from: classes6.dex */
public class e<T> extends j<T> {
    private final rx.e<T> opr;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.opr = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.opr.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.opr.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.opr.onNext(t);
    }
}
