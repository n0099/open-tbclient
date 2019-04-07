package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> jYB;
    final rx.functions.b<? super T> kac;
    final rx.functions.a kad;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kac = bVar;
        this.jYB = bVar2;
        this.kad = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kac.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jYB.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kad.call();
    }
}
