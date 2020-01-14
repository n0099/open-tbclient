package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nRC;

    public d(rx.e<? super T> eVar) {
        this.nRC = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nRC.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRC.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nRC.onCompleted();
    }
}
