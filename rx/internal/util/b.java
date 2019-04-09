package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> jYC;
    final rx.functions.b<? super T> kad;
    final rx.functions.a kae;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kad = bVar;
        this.jYC = bVar2;
        this.kae = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kad.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jYC.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kae.call();
    }
}
