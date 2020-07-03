package rx.b;

import rx.j;
/* loaded from: classes6.dex */
public class e<T> extends j<T> {
    private final rx.e<T> ogG;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.ogG = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ogG.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ogG.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ogG.onNext(t);
    }
}
