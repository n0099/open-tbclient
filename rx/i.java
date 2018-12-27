package rx;
/* loaded from: classes2.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.j iEq = new rx.internal.util.j();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.iEq.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.iEq.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.iEq.isUnsubscribed();
    }
}
