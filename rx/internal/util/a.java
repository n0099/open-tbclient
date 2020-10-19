package rx.internal.util;
/* loaded from: classes16.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> pgD;
    final rx.functions.b<? super T> phP;
    final rx.functions.a phQ;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.phP = bVar;
        this.pgD = bVar2;
        this.phQ = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.phP.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pgD.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.phQ.call();
    }
}
