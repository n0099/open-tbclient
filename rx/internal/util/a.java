package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nRa;
    final rx.functions.b<? super T> nSm;
    final rx.functions.a nSn;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nSm = bVar;
        this.nRa = bVar2;
        this.nSn = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSm.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRa.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSn.call();
    }
}
