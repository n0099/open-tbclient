package rx.b;

import rx.j;
/* loaded from: classes6.dex */
public class e<T> extends j<T> {
    private final rx.e<T> nJI;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.nJI = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nJI.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nJI.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nJI.onNext(t);
    }
}
