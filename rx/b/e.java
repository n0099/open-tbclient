package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public class e<T> extends j<T> {
    private final rx.e<T> kEy;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.kEy = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kEy.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kEy.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kEy.onNext(t);
    }
}
