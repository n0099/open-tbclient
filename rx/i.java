package rx;
/* loaded from: classes2.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.j itX = new rx.internal.util.j();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.itX.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.itX.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.itX.isUnsubscribed();
    }
}
