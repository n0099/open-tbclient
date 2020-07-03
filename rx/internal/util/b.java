package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> oeH;
    final rx.functions.b<? super T> ofU;
    final rx.functions.a ofV;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.ofU = bVar;
        this.oeH = bVar2;
        this.ofV = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ofU.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.oeH.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ofV.call();
    }
}
