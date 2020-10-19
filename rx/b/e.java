package rx.b;

import rx.j;
/* loaded from: classes16.dex */
public class e<T> extends j<T> {
    private final rx.e<T> piE;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.piE = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.piE.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.piE.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.piE.onNext(t);
    }
}
