package rx.internal.util;
/* loaded from: classes2.dex */
public final class c<T> extends rx.j<T> {
    final rx.functions.b<Throwable> iBt;
    final rx.functions.b<? super T> iCU;
    final rx.functions.a iCV;

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.iCU = bVar;
        this.iBt = bVar2;
        this.iCV = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iCU.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iBt.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iCV.call();
    }
}
