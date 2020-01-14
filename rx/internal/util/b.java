package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nQl;
    final rx.functions.b<? super T> nRx;
    final rx.functions.a nRy;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.nRx = bVar;
        this.nQl = bVar2;
        this.nRy = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nRx.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nQl.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nRy.call();
    }
}
