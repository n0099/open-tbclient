package rx.b;

import rx.j;
/* loaded from: classes16.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qjp;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qjp = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qjp.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qjp.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qjp.onNext(t);
    }
}
