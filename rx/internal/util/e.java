package rx.internal.util;
/* loaded from: classes2.dex */
public final class e<T> extends rx.j<T> {
    final rx.e<? super T> iDb;

    public e(rx.e<? super T> eVar) {
        this.iDb = eVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.iDb.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.iDb.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.iDb.onCompleted();
    }
}
