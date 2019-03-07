package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class e<T> extends j<T> {
    private final rx.e<T> kbE;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.kbE = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kbE.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kbE.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kbE.onNext(t);
    }
}
