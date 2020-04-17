package rx.internal.util;
/* loaded from: classes6.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> nmH;
    final rx.functions.b<? super T> nnT;
    final rx.functions.a nnU;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.nnT = bVar;
        this.nmH = bVar2;
        this.nnU = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nnT.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nmH.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nnU.call();
    }
}
