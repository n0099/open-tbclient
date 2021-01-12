package rx.internal.util;
/* loaded from: classes14.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qrE;
    final rx.functions.b<? super T> qsP;
    final rx.functions.a qsQ;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
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
