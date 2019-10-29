package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> kCA;
    final rx.functions.b<? super T> kEb;
    final rx.functions.a kEc;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kEb = bVar;
        this.kCA = bVar2;
        this.kEc = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kEb.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kCA.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kEc.call();
    }
}
