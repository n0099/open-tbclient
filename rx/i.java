package rx;
/* loaded from: classes2.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i jVx = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.jVx.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.jVx.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.jVx.isUnsubscribed();
    }
}
