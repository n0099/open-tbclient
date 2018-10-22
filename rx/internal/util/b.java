package rx.internal.util;
/* loaded from: classes2.dex */
public final class b<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> iBu;
    final rx.functions.b<? super T> iCV;
    final rx.functions.a iCW;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.iCV = bVar;
        this.iBu = bVar2;
        this.iCW = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iCV.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iBu.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iCW.call();
    }
}
