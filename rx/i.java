package rx;
/* loaded from: classes4.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i qzc = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.qzc.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.qzc.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.qzc.isUnsubscribed();
    }
}
