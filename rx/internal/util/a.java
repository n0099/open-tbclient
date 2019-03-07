package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> jYY;
    final rx.functions.a kaA;
    final rx.functions.b<? super T> kaz;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kaz = bVar;
        this.jYY = bVar2;
        this.kaA = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kaz.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jYY.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kaA.call();
    }
}
