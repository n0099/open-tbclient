package rx.internal.util;

import rx.j;
/* loaded from: classes12.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> pSV;
    final rx.functions.b<? super T> pUh;
    final rx.functions.a pUi;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.pUh = bVar;
        this.pSV = bVar2;
        this.pUi = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUh.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pSV.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUi.call();
    }
}
