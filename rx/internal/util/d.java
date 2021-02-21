package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qDy;

    public d(rx.e<? super T> eVar) {
        this.qDy = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qDy.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qDy.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qDy.onCompleted();
    }
}
