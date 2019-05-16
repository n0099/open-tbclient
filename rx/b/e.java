package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class e<T> extends j<T> {
    private final rx.e<T> ktx;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.ktx = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ktx.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ktx.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ktx.onNext(t);
    }
}
