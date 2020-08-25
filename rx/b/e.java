package rx.b;

import rx.j;
/* loaded from: classes5.dex */
public class e<T> extends j<T> {
    private final rx.e<T> oJo;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.oJo = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oJo.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oJo.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oJo.onNext(t);
    }
}
