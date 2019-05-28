package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> kqS;
    final rx.functions.b<? super T> kst;
    final rx.functions.a ksu;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kst = bVar;
        this.kqS = bVar2;
        this.ksu = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kst.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kqS.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ksu.call();
    }
}
