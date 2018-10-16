package rx.internal.util;
/* loaded from: classes2.dex */
public final class b<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> iBt;
    final rx.functions.b<? super T> iCU;
    final rx.functions.a iCV;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.iCU = bVar;
        this.iBt = bVar2;
        this.iCV = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iCU.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iBt.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iCV.call();
    }
}
