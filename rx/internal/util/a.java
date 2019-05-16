package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> kqR;
    final rx.functions.b<? super T> kss;
    final rx.functions.a kst;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kss = bVar;
        this.kqR = bVar2;
        this.kst = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kss.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kqR.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kst.call();
    }
}
