package rx;
/* loaded from: classes4.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i ndz = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.ndz.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.ndz.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.ndz.isUnsubscribed();
    }
}
