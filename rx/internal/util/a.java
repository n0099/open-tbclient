package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nTa;
    final rx.functions.b<? super T> nUm;
    final rx.functions.a nUn;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nUm = bVar;
        this.nTa = bVar2;
        this.nUn = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nUm.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nTa.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nUn.call();
    }
}
