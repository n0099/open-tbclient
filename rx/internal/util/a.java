package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nHK;
    final rx.functions.b<? super T> nIW;
    final rx.functions.a nIX;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nIW = bVar;
        this.nHK = bVar2;
        this.nIX = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nIW.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nHK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nIX.call();
    }
}
