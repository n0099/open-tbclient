package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nQg;
    final rx.functions.b<? super T> nRs;
    final rx.functions.a nRt;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.nRs = bVar;
        this.nQg = bVar2;
        this.nRt = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nRs.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nQg.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nRt.call();
    }
}
