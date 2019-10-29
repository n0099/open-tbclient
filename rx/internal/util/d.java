package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kEk;

    public d(rx.e<? super T> eVar) {
        this.kEk = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kEk.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kEk.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kEk.onCompleted();
    }
}
