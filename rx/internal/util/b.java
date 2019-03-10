package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> jZr;
    final rx.functions.b<? super T> kaS;
    final rx.functions.a kaT;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kaS = bVar;
        this.jZr = bVar2;
        this.kaT = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kaS.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jZr.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kaT.call();
    }
}
