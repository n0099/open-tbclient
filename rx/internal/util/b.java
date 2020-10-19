package rx.internal.util;

import rx.j;
/* loaded from: classes16.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> pgD;
    final rx.functions.b<? super T> phP;
    final rx.functions.a phQ;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.phP = bVar;
        this.pgD = bVar2;
        this.phQ = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.phP.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.pgD.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.phQ.call();
    }
}
