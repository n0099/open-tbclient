package rx.internal.util;

import rx.j;
/* loaded from: classes15.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qvO;

    public d(rx.e<? super T> eVar) {
        this.qvO = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qvO.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qvO.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qvO.onCompleted();
    }
}
