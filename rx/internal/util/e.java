package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> extends rx.j<T> {
    final rx.e<? super T> iDc;

    public e(rx.e<? super T> eVar) {
        this.iDc = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iDc.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iDc.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iDc.onCompleted();
    }
}
