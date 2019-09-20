package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kDC;

    public d(rx.e<? super T> eVar) {
        this.kDC = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kDC.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kDC.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kDC.onCompleted();
    }
}
