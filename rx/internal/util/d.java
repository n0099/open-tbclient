package rx.internal.util;

import rx.j;
/* loaded from: classes12.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> pUm;

    public d(rx.e<? super T> eVar) {
        this.pUm = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUm.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pUm.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUm.onCompleted();
    }
}
