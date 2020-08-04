package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> onv;
    final rx.functions.b<? super T> ooH;
    final rx.functions.a ooI;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.ooH = bVar;
        this.onv = bVar2;
        this.ooI = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ooH.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.onv.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ooI.call();
    }
}
