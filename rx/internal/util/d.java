package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nJb;

    public d(rx.e<? super T> eVar) {
        this.nJb = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nJb.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nJb.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nJb.onCompleted();
    }
}
