package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class e<T> extends j<T> {
    private final rx.e<T> kty;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.kty = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kty.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kty.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kty.onNext(t);
    }
}
