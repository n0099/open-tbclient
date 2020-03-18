package rx.b;

import rx.j;
/* loaded from: classes6.dex */
public class e<T> extends j<T> {
    private final rx.e<T> nUX;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.nUX = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nUX.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nUX.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nUX.onNext(t);
    }
}
