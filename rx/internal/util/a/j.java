package rx.internal.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public abstract class j<E> extends l<E> {
    protected static final long qxQ = ae.m(j.class, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eLV() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Y(long j, long j2) {
        return ae.qxX.a(this, qxQ, j, j2);
    }
}
