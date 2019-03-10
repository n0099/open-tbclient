package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class e<T> extends j<T> {
    private final rx.e<T> kbX;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.kbX = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kbX.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kbX.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kbX.onNext(t);
    }
}
