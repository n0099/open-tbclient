package rx.internal.util;
/* loaded from: classes5.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qBI;
    final rx.functions.b<? super T> qCT;
    final rx.functions.a qCU;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.qCT = bVar;
        this.qBI = bVar2;
        this.qCU = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qCT.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qBI.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qCU.call();
    }
}
