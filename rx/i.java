package rx;
/* loaded from: classes14.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i qnW = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.qnW.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.qnW.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.qnW.isUnsubscribed();
    }
}
