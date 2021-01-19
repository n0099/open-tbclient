package rx.internal.util;

import rx.j;
/* loaded from: classes14.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qsV;

    public d(rx.e<? super T> eVar) {
        this.qsV = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qsV.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qsV.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qsV.onCompleted();
    }
}
