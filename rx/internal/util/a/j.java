package rx.internal.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j<E> extends l<E> {
    protected static final long kto = ae.j(j.class, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cMl() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean A(long j, long j2) {
        return ae.ktv.compareAndSwapLong(this, kto, j, j2);
    }
}
