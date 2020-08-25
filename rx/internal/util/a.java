package rx.internal.util;
/* loaded from: classes5.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> oHq;
    final rx.functions.b<? super T> oIC;
    final rx.functions.a oID;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.oIC = bVar;
        this.oHq = bVar2;
        this.oID = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oIC.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oHq.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oID.call();
    }
}
