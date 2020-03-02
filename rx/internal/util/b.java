package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nRc;
    final rx.functions.b<? super T> nSo;
    final rx.functions.a nSp;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.nSo = bVar;
        this.nRc = bVar2;
        this.nSp = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nSo.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nRc.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nSp.call();
    }
}
