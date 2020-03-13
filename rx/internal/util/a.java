package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nRn;
    final rx.functions.a nSA;
    final rx.functions.b<? super T> nSz;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nSz = bVar;
        this.nRn = bVar2;
        this.nSA = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSz.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRn.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSA.call();
    }
}
