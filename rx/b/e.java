package rx.b;

import rx.j;
/* loaded from: classes7.dex */
public class e<T> extends j<T> {
    private final rx.e<T> oTl;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.oTl = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oTl.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oTl.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oTl.onNext(t);
    }
}
