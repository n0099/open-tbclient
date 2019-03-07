package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kaI;

    public d(rx.e<? super T> eVar) {
        this.kaI = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kaI.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kaI.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kaI.onCompleted();
    }
}
