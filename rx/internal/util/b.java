package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kyu;
    final rx.functions.b<? super T> kzV;
    final rx.functions.a kzW;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kzV = bVar;
        this.kyu = bVar2;
        this.kzW = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kzV.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kyu.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kzW.call();
    }
}
