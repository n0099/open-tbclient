package rx.internal.util;
/* loaded from: classes14.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qrF;
    final rx.functions.b<? super T> qsQ;
    final rx.functions.a qsR;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
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
