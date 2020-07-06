package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> oeK;
    final rx.functions.b<? super T> ofX;
    final rx.functions.a ofY;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.ofX = bVar;
        this.oeK = bVar2;
        this.ofY = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ofX.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oeK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ofY.call();
    }
}
