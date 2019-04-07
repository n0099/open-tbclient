package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> jYB;
    final rx.functions.b<? super T> kac;
    final rx.functions.a kad;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kac = bVar;
        this.jYB = bVar2;
        this.kad = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kac.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jYB.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kad.call();
    }
}
