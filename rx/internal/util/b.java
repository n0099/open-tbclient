package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> oeK;
    final rx.functions.b<? super T> ofX;
    final rx.functions.a ofY;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.ofX = bVar;
        this.oeK = bVar2;
        this.ofY = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ofX.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oeK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ofY.call();
    }
}
