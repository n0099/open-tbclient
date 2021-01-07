package rx.b;

import rx.j;
/* loaded from: classes15.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qyd;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qyd = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qyd.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qyd.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qyd.onNext(t);
    }
}
