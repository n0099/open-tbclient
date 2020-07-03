package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> ofZ;

    public d(rx.e<? super T> eVar) {
        this.ofZ = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ofZ.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ofZ.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ofZ.onCompleted();
    }
}
