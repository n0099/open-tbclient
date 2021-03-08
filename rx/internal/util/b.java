package rx.internal.util;

import rx.j;
/* loaded from: classes4.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> qCK;
    final rx.functions.b<? super T> qDV;
    final rx.functions.a qDW;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qDV = bVar;
        this.qCK = bVar2;
        this.qDW = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qDV.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qCK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qDW.call();
    }
}
