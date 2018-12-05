package rx.internal.util;
/* loaded from: classes2.dex */
public final class c<T> extends rx.j<T> {
    final rx.functions.b<Throwable> iKm;
    final rx.functions.b<? super T> iLM;
    final rx.functions.a iLN;

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.iLM = bVar;
        this.iKm = bVar2;
        this.iLN = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iLM.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iKm.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iLN.call();
    }
}
