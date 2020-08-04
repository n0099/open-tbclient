package rx;
/* loaded from: classes6.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i ojL = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.ojL.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.ojL.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.ojL.isUnsubscribed();
    }
}
