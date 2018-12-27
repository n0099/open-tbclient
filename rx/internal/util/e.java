package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> extends rx.j<T> {
    final rx.e<? super T> iPd;

    public e(rx.e<? super T> eVar) {
        this.iPd = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iPd.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iPd.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iPd.onCompleted();
    }
}
