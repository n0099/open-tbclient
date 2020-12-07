package rx.internal.util;
/* loaded from: classes12.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> pSV;
    final rx.functions.b<? super T> pUh;
    final rx.functions.a pUi;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.pUh = bVar;
        this.pSV = bVar2;
        this.pUi = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUh.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pSV.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUi.call();
    }
}
