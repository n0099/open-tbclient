package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kqS;
    final rx.functions.b<? super T> kst;
    final rx.functions.a ksu;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kst = bVar;
        this.kqS = bVar2;
        this.ksu = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kst.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kqS.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ksu.call();
    }
}
