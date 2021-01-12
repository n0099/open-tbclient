package rx.b;

import rx.j;
/* loaded from: classes14.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qtB;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qtB = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qtB.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qtB.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qtB.onNext(t);
    }
}
