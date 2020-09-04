package rx.internal.util;
/* loaded from: classes5.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> oHI;
    final rx.functions.b<? super T> oIU;
    final rx.functions.a oIV;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.oIU = bVar;
        this.oHI = bVar2;
        this.oIV = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oIU.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oHI.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oIV.call();
    }
}
