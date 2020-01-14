package rx.b;

import rx.j;
/* loaded from: classes5.dex */
public class e<T> extends j<T> {
    private final rx.e<T> nSj;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.nSj = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSj.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nSj.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSj.onNext(t);
    }
}
