package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> ksC;

    public d(rx.e<? super T> eVar) {
        this.ksC = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ksC.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ksC.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ksC.onCompleted();
    }
}
