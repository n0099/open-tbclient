package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> jZr;
    final rx.functions.b<? super T> kaS;
    final rx.functions.a kaT;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kaS = bVar;
        this.jZr = bVar2;
        this.kaT = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kaS.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jZr.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kaT.call();
    }
}
