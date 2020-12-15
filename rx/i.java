package rx;
/* loaded from: classes12.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i pPo = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.pPo.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.pPo.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.pPo.isUnsubscribed();
    }
}
