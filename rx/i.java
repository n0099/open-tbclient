package rx;
/* loaded from: classes2.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.j isn = new rx.internal.util.j();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.isn.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.isn.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.isn.isUnsubscribed();
    }
}
