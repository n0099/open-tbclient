package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> extends rx.j<T> {
    final rx.e<? super T> iQl;

    public e(rx.e<? super T> eVar) {
        this.iQl = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iQl.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iQl.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iQl.onCompleted();
    }
}
