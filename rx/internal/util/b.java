package rx.internal.util;

import rx.j;
/* loaded from: classes5.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> oHq;
    final rx.functions.b<? super T> oIC;
    final rx.functions.a oID;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.oIC = bVar;
        this.oHq = bVar2;
        this.oID = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.oIC.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oHq.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.oID.call();
    }
}
