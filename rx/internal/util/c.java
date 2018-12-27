package rx.internal.util;
/* loaded from: classes2.dex */
public final class c<T> extends rx.j<T> {
    final rx.functions.b<Throwable> iNw;
    final rx.functions.b<? super T> iOW;
    final rx.functions.a iOX;

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.iOW = bVar;
        this.iNw = bVar2;
        this.iOX = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iOW.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iNw.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iOX.call();
    }
}
