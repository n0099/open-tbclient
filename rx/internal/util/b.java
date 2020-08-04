package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> onv;
    final rx.functions.b<? super T> ooH;
    final rx.functions.a ooI;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.ooH = bVar;
        this.onv = bVar2;
        this.ooI = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ooH.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.onv.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ooI.call();
    }
}
