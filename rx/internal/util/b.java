package rx.internal.util;

import rx.j;
/* loaded from: classes6.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> nmK;
    final rx.functions.b<? super T> nnW;
    final rx.functions.a nnX;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.nnW = bVar;
        this.nmK = bVar2;
        this.nnX = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.nnW.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.nmK.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.nnX.call();
    }
}
