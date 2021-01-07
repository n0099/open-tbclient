package rx.internal.util;
/* loaded from: classes15.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> qwg;
    final rx.functions.b<? super T> qxr;
    final rx.functions.a qxs;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.qxr = bVar;
        this.qwg = bVar2;
        this.qxs = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qxr.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qwg.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qxs.call();
    }
}
