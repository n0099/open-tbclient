package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nRa;
    final rx.functions.b<? super T> nSm;
    final rx.functions.a nSn;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.nSm = bVar;
        this.nRa = bVar2;
        this.nSn = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSm.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRa.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSn.call();
    }
}
