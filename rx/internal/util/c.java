package rx.internal.util;
/* loaded from: classes2.dex */
public final class c<T> extends rx.j<T> {
    final rx.functions.b<Throwable> iBu;
    final rx.functions.b<? super T> iCV;
    final rx.functions.a iCW;

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.iCV = bVar;
        this.iBu = bVar2;
        this.iCW = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iCV.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iBu.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iCW.call();
    }
}
