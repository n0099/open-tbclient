package rx;
/* loaded from: classes6.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i nNu = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.nNu.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.nNu.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.nNu.isUnsubscribed();
    }
}
