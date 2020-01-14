package rx;
/* loaded from: classes5.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i nMD = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.nMD.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.nMD.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.nMD.isUnsubscribed();
    }
}
