package rx.internal.util;

import rx.j;
/* loaded from: classes16.dex */
public final class d<T> extends j<T> {
    final rx.e<? super T> qiI;

    public d(rx.e<? super T> eVar) {
        this.qiI = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qiI.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qiI.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qiI.onCompleted();
    }
}
