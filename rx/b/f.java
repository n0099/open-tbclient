package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class f<T> extends j<T> {
    private final rx.e<T> iEr;

    public f(j<? super T> jVar) {
        this(jVar, true);
    }

    public f(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.iEr = new e(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iEr.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iEr.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iEr.onNext(t);
    }
}
