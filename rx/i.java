package rx;
/* loaded from: classes2.dex */
public abstract class i<T> implements k {
    private final rx.internal.util.i kuB = new rx.internal.util.i();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(k kVar) {
        this.kuB.add(kVar);
    }

    @Override // rx.k
    public final void unsubscribe() {
        this.kuB.unsubscribe();
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.kuB.isUnsubscribed();
    }
}
