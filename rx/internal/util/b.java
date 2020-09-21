package rx.internal.util;

import rx.j;
/* loaded from: classes7.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> oRn;
    final rx.functions.a oSA;
    final rx.functions.b<? super T> oSz;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.oSz = bVar;
        this.oRn = bVar2;
        this.oSA = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oSz.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oRn.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oSA.call();
    }
}
