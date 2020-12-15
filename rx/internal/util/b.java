package rx.internal.util;

import rx.j;
/* loaded from: classes12.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> pSX;
    final rx.functions.b<? super T> pUj;
    final rx.functions.a pUk;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.pUj = bVar;
        this.pSX = bVar2;
        this.pUk = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.pUj.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pSX.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.pUk.call();
    }
}
