package rx.internal.util;

import rx.j;
/* loaded from: classes2.dex */
public final class b<T> extends j<T> {
    final rx.functions.b<Throwable> kqV;
    final rx.functions.b<? super T> ksw;
    final rx.functions.a ksx;

    public b(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.ksw = bVar;
        this.kqV = bVar2;
        this.ksx = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.ksw.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kqV.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.ksx.call();
    }
}
