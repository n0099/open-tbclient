package rx.internal.util;

import rx.j;
/* loaded from: classes16.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> pZn;

    public d(rx.e<? super T> eVar) {
        this.pZn = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pZn.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pZn.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pZn.onCompleted();
    }
}
