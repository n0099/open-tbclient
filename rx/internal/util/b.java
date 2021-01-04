package rx.internal.util;

import rx.j;
/* loaded from: classes15.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> quy;
    final rx.functions.b<? super T> qvJ;
    final rx.functions.a qvK;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.qvJ = bVar;
        this.quy = bVar2;
        this.qvK = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.qvJ.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.quy.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.qvK.call();
    }
}
