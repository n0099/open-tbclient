package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> extends rx.j<T> {
    final rx.e<? super T> iQk;

    public e(rx.e<? super T> eVar) {
        this.iQk = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQk.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iQk.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQk.onCompleted();
    }
}
