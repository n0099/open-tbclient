package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> ooK;

    public d(rx.e<? super T> eVar) {
        this.ooK = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ooK.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ooK.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ooK.onCompleted();
    }
}
