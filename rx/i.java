package rx;
/* loaded from: classes16.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i pcU = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.pcU.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.pcU.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.pcU.isUnsubscribed();
    }
}
