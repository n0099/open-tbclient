package rx.internal.util;

import rx.j;
/* loaded from: classes16.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> phU;

    public d(rx.e<? super T> eVar) {
        this.phU = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.phU.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.phU.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.phU.onCompleted();
    }
}
