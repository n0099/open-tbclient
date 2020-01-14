package rx.internal.util;
/* loaded from: classes5.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nQl;
    final rx.functions.b<? super T> nRx;
    final rx.functions.a nRy;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nRx = bVar;
        this.nQl = bVar2;
        this.nRy = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nRx.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nQl.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nRy.call();
    }
}
