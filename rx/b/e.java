package rx.b;

import rx.j;
/* loaded from: classes5.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qEf;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qEf = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qEf.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qEf.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qEf.onNext(t);
    }
}
