package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kal;

    public d(rx.e<? super T> eVar) {
        this.kal = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kal.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kal.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kal.onCompleted();
    }
}
