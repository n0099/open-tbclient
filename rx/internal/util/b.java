package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> qCi;
    final rx.functions.b<? super T> qDt;
    final rx.functions.a qDu;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qDt = bVar;
        this.qCi = bVar2;
        this.qDu = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qDt.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.qCi.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qDu.call();
    }
}
