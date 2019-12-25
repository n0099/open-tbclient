package rx.internal.util;

import rx.j;
/* loaded from: classes4.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> niA;

    public d(rx.e<? super T> eVar) {
        this.niA = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.niA.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.niA.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.niA.onCompleted();
    }
}
