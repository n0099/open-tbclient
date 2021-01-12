package rx.internal.util;

import rx.j;
/* loaded from: classes14.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> qrE;
    final rx.functions.b<? super T> qsP;
    final rx.functions.a qsQ;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qsP = bVar;
        this.qrE = bVar2;
        this.qsQ = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qsP.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qrE.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qsQ.call();
    }
}
