package rx.internal.util;
/* loaded from: classes2.dex */
public final class b<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> iOE;
    final rx.functions.b<? super T> iQe;
    final rx.functions.a iQf;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.iQe = bVar;
        this.iOE = bVar2;
        this.iQf = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQe.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iOE.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQf.call();
    }
}
