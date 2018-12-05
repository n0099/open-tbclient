package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> extends rx.j<T> {
    final rx.e<? super T> iLT;

    public e(rx.e<? super T> eVar) {
        this.iLT = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iLT.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iLT.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iLT.onCompleted();
    }
}
