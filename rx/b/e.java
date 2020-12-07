package rx.b;

import rx.j;
/* loaded from: classes12.dex */
public class e<T> extends j<T> {
    private final rx.e<T> pUT;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.pUT = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUT.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pUT.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUT.onNext(t);
    }
}
