package rx.internal.util;

import rx.j;
/* loaded from: classes14.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> qrF;
    final rx.functions.b<? super T> qsQ;
    final rx.functions.a qsR;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qsQ = bVar;
        this.qrF = bVar2;
        this.qsR = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qsQ.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qrF.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qsR.call();
    }
}
