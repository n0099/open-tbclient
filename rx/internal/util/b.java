package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> jYY;
    final rx.functions.a kaA;
    final rx.functions.b<? super T> kaz;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kaz = bVar;
        this.jYY = bVar2;
        this.kaA = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kaz.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jYY.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kaA.call();
    }
}
