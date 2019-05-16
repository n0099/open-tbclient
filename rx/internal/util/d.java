package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> ksB;

    public d(rx.e<? super T> eVar) {
        this.ksB = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ksB.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ksB.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ksB.onCompleted();
    }
}
