package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kBS;
    final rx.functions.b<? super T> kDt;
    final rx.functions.a kDu;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kDt = bVar;
        this.kBS = bVar2;
        this.kDu = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kDt.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kBS.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kDu.call();
    }
}
