package rx;
/* loaded from: classes7.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i oNE = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.oNE.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.oNE.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.oNE.isUnsubscribed();
    }
}
