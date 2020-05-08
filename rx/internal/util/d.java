package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> nob;

    public d(rx.e<? super T> eVar) {
        this.nob = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nob.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nob.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nob.onCompleted();
    }
}
