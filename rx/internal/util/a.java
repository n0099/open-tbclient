package rx.internal.util;
/* loaded from: classes16.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> pXW;
    final rx.functions.b<? super T> pZi;
    final rx.functions.a pZj;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.pZi = bVar;
        this.pXW = bVar2;
        this.pZj = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pZi.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pXW.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pZj.call();
    }
}
