package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nSt;

    public d(rx.e<? super T> eVar) {
        this.nSt = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSt.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nSt.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSt.onCompleted();
    }
}
