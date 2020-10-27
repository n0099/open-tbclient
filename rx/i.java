package rx;
/* loaded from: classes16.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i pUn = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.pUn.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.pUn.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.pUn.isUnsubscribed();
    }
}
