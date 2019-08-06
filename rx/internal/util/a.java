package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super T> kBb;
    final rx.functions.a kBc;
    final rx.functions.b<? super Throwable> kzA;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kBb = bVar;
        this.kzA = bVar2;
        this.kBc = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kBb.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kzA.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kBc.call();
    }
}
