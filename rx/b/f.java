package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class f<T> extends j<T> {
    private final rx.e<T> iQs;

    public f(j<? super T> jVar) {
        this(jVar, true);
    }

    public f(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.iQs = new e(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQs.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iQs.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQs.onNext(t);
    }
}
