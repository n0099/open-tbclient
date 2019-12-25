package rx.internal.util;

import rx.j;
/* loaded from: classes4.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nhi;
    final rx.functions.b<? super T> niv;
    final rx.functions.a niw;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.niv = bVar;
        this.nhi = bVar2;
        this.niw = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.niv.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nhi.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.niw.call();
    }
}
