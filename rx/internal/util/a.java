package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> oeH;
    final rx.functions.b<? super T> ofU;
    final rx.functions.a ofV;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.ofU = bVar;
        this.oeH = bVar2;
        this.ofV = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ofU.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oeH.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ofV.call();
    }
}
