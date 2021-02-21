package rx.internal.util;
/* loaded from: classes5.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qCi;
    final rx.functions.b<? super T> qDt;
    final rx.functions.a qDu;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.qDt = bVar;
        this.qCi = bVar2;
        this.qDu = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qDt.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qCi.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qDu.call();
    }
}
