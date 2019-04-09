package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kam;

    public d(rx.e<? super T> eVar) {
        this.kam = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kam.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kam.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kam.onCompleted();
    }
}
