package rx;
/* loaded from: classes15.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i qsy = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.qsy.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.qsy.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.qsy.isUnsubscribed();
    }
}
