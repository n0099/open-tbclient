package rx;
/* loaded from: classes6.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i nEb = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.nEb.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.nEb.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.nEb.isUnsubscribed();
    }
}
