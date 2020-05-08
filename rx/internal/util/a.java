package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nmK;
    final rx.functions.b<? super T> nnW;
    final rx.functions.a nnX;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nnW = bVar;
        this.nmK = bVar2;
        this.nnX = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nnW.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nmK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nnX.call();
    }
}
