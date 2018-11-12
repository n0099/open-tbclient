package rx.internal.util;
/* loaded from: classes2.dex */
public final class b<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> iDe;
    final rx.functions.b<? super T> iEF;
    final rx.functions.a iEG;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.iEF = bVar;
        this.iDe = bVar2;
        this.iEG = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iEF.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iDe.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iEG.call();
    }
}
