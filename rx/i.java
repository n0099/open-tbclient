package rx;
/* loaded from: classes14.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i qfk = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.qfk.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.qfk.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.qfk.isUnsubscribed();
    }
}
