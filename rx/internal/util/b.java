package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kBJ;
    final rx.functions.b<? super T> kDk;
    final rx.functions.a kDl;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kDk = bVar;
        this.kBJ = bVar2;
        this.kDl = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kDk.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kBJ.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kDl.call();
    }
}
