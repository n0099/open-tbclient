package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> kBk;

    public d(rx.e<? super T> eVar) {
        this.kBk = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kBk.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kBk.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kBk.onCompleted();
    }
}
