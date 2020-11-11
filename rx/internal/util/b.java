package rx.internal.util;

import rx.j;
/* loaded from: classes16.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> qhq;
    final rx.functions.b<? super T> qiD;
    final rx.functions.a qiE;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qiD = bVar;
        this.qhq = bVar2;
        this.qiE = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qiD.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qhq.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qiE.call();
    }
}
