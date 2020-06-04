package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nIU;
    final rx.functions.b<? super T> nKg;
    final rx.functions.a nKh;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nKg = bVar;
        this.nIU = bVar2;
        this.nKh = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nKg.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nIU.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nKh.call();
    }
}
