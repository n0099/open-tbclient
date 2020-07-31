package rx;
/* loaded from: classes6.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i ojJ = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.ojJ.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.ojJ.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.ojJ.isUnsubscribed();
    }
}
