package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kDt;

    public d(rx.e<? super T> eVar) {
        this.kDt = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kDt.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kDt.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kDt.onCompleted();
    }
}
