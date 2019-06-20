package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> ksF;

    public d(rx.e<? super T> eVar) {
        this.ksF = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ksF.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ksF.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ksF.onCompleted();
    }
}
