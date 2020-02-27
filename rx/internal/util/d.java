package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nSr;

    public d(rx.e<? super T> eVar) {
        this.nSr = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSr.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nSr.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSr.onCompleted();
    }
}
