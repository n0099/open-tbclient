package rx.internal.util;

import rx.j;
/* loaded from: classes7.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> oSE;

    public d(rx.e<? super T> eVar) {
        this.oSE = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oSE.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oSE.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oSE.onCompleted();
    }
}
