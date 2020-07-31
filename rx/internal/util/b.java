package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> ont;
    final rx.functions.b<? super T> ooF;
    final rx.functions.a ooG;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.ooF = bVar;
        this.ont = bVar2;
        this.ooG = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ooF.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.ont.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ooG.call();
    }
}
