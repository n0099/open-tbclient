package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nKl;

    public d(rx.e<? super T> eVar) {
        this.nKl = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nKl.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nKl.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nKl.onCompleted();
    }
}
