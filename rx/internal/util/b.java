package rx.internal.util;
/* loaded from: classes2.dex */
public final class b<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> iOD;
    final rx.functions.b<? super T> iQd;
    final rx.functions.a iQe;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.iQd = bVar;
        this.iOD = bVar2;
        this.iQe = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQd.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iOD.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQe.call();
    }
}
