package rx.b;

import rx.j;
/* loaded from: classes14.dex */
public class e<T> extends j<T> {
    private final rx.e<T> qkS;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.qkS = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qkS.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qkS.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qkS.onNext(t);
    }
}
