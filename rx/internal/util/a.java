package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nRc;
    final rx.functions.b<? super T> nSo;
    final rx.functions.a nSp;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nSo = bVar;
        this.nRc = bVar2;
        this.nSp = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSo.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRc.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSp.call();
    }
}
