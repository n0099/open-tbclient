package rx.b;

import rx.j;
/* loaded from: classes12.dex */
public class e<T> extends j<T> {
    private final rx.e<T> pUV;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.pUV = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUV.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pUV.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUV.onNext(t);
    }
}
