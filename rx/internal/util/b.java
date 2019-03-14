package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> jZj;
    final rx.functions.b<? super T> kaK;
    final rx.functions.a kaL;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.kaK = bVar;
        this.jZj = bVar2;
        this.kaL = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kaK.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.jZj.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kaL.call();
    }
}
