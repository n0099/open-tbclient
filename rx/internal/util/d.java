package rx.internal.util;

import rx.j;
/* loaded from: classes14.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qsU;

    public d(rx.e<? super T> eVar) {
        this.qsU = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qsU.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qsU.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qsU.onCompleted();
    }
}
