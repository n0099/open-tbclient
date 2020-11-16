package rx.internal.util;

import rx.j;
/* loaded from: classes14.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qkl;

    public d(rx.e<? super T> eVar) {
        this.qkl = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qkl.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qkl.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qkl.onCompleted();
    }
}
