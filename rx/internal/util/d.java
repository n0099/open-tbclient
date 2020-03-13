package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nSE;

    public d(rx.e<? super T> eVar) {
        this.nSE = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSE.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nSE.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSE.onCompleted();
    }
}
