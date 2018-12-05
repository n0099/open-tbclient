package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class f<T> extends j<T> {
    private final rx.e<T> iNi;

    public f(j<? super T> jVar) {
        this(jVar, true);
    }

    public f(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.iNi = new e(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iNi.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iNi.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iNi.onNext(t);
    }
}
