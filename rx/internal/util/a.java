package rx.internal.util;
/* loaded from: classes14.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qiU;
    final rx.functions.b<? super T> qkg;
    final rx.functions.a qkh;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.qkg = bVar;
        this.qiU = bVar2;
        this.qkh = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qkg.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qiU.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qkh.call();
    }
}
