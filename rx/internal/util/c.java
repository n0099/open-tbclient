package rx.internal.util;
/* loaded from: classes2.dex */
public final class c<T> extends rx.j<T> {
    final rx.functions.b<Throwable> iOE;
    final rx.functions.b<? super T> iQe;
    final rx.functions.a iQf;

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.iQe = bVar;
        this.iOE = bVar2;
        this.iQf = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQe.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iOE.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQf.call();
    }
}
