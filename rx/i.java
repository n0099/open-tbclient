package rx;
/* loaded from: classes2.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i jUH = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.jUH.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.jUH.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.jUH.isUnsubscribed();
    }
}
