package rx.internal.util;
/* loaded from: classes7.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> oRn;
    final rx.functions.a oSA;
    final rx.functions.b<? super T> oSz;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.oSz = bVar;
        this.oRn = bVar2;
        this.oSA = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oSz.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oRn.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oSA.call();
    }
}
