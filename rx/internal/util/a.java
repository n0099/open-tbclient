package rx.internal.util;
/* loaded from: classes15.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> quy;
    final rx.functions.b<? super T> qvJ;
    final rx.functions.a qvK;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.qvJ = bVar;
        this.quy = bVar2;
        this.qvK = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qvJ.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.quy.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qvK.call();
    }
}
