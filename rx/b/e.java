package rx.b;

import rx.j;
/* loaded from: classes4.dex */
public class e<T> extends j<T> {
    private final rx.e<T> njh;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.njh = new d(jVar);
    }

    @Override // rx.e
    public void onCompleted() {
        this.njh.onCompleted();
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.njh.onError(th);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.njh.onNext(t);
    }
}
