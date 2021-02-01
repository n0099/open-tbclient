package rx.b;

import rx.j;
/* loaded from: classes5.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qDF;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qDF = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qDF.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qDF.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qDF.onNext(t);
    }
}
