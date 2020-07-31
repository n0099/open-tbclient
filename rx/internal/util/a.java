package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> ont;
    final rx.functions.b<? super T> ooF;
    final rx.functions.a ooG;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.ooF = bVar;
        this.ont = bVar2;
        this.ooG = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ooF.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ont.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ooG.call();
    }
}
