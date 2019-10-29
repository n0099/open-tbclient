package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kCA;
    final rx.functions.b<? super T> kEb;
    final rx.functions.a kEc;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kEb = bVar;
        this.kCA = bVar2;
        this.kEc = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kEb.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kCA.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kEc.call();
    }
}
