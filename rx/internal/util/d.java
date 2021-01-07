package rx.internal.util;

import rx.j;
/* loaded from: classes15.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qxw;

    public d(rx.e<? super T> eVar) {
        this.qxw = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qxw.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qxw.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qxw.onCompleted();
    }
}
