package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nRx;

    public d(rx.e<? super T> eVar) {
        this.nRx = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nRx.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRx.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nRx.onCompleted();
    }
}
