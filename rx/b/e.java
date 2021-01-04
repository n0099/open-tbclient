package rx.b;

import rx.j;
/* loaded from: classes15.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qwv;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qwv = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qwv.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qwv.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qwv.onNext(t);
    }
}
