package rx.internal.util;

import rx.j;
/* loaded from: classes12.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> pUo;

    public d(rx.e<? super T> eVar) {
        this.pUo = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUo.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pUo.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUo.onCompleted();
    }
}
