package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kbb;

    public d(rx.e<? super T> eVar) {
        this.kbb = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kbb.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kbb.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kbb.onCompleted();
    }
}
