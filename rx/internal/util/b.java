package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> qBI;
    final rx.functions.b<? super T> qCT;
    final rx.functions.a qCU;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qCT = bVar;
        this.qBI = bVar2;
        this.qCU = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qCT.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qBI.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qCU.call();
    }
}
