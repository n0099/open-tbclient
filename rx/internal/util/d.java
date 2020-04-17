package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nnY;

    public d(rx.e<? super T> eVar) {
        this.nnY = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nnY.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nnY.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nnY.onCompleted();
    }
}
