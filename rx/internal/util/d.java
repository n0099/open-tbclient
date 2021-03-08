package rx.internal.util;

import rx.j;
/* loaded from: classes4.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qEa;

    public d(rx.e<? super T> eVar) {
        this.qEa = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qEa.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qEa.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qEa.onCompleted();
    }
}
