package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nHK;
    final rx.functions.b<? super T> nIW;
    final rx.functions.a nIX;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.nIW = bVar;
        this.nHK = bVar2;
        this.nIX = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nIW.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nHK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nIX.call();
    }
}
