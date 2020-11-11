package rx.internal.util;
/* loaded from: classes16.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qhq;
    final rx.functions.b<? super T> qiD;
    final rx.functions.a qiE;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.qiD = bVar;
        this.qhq = bVar2;
        this.qiE = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qiD.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qhq.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qiE.call();
    }
}
