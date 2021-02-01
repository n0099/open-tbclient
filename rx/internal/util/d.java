package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qCY;

    public d(rx.e<? super T> eVar) {
        this.qCY = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qCY.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qCY.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qCY.onCompleted();
    }
}
