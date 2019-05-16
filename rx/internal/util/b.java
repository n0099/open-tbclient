package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kqR;
    final rx.functions.b<? super T> kss;
    final rx.functions.a kst;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kss = bVar;
        this.kqR = bVar2;
        this.kst = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kss.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kqR.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kst.call();
    }
}
