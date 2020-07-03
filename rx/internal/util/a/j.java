package rx.internal.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class j<E> extends l<E> {
    protected static final long ogt = ae.l(j.class, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dPH() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean W(long j, long j2) {
        return ae.ogA.a(this, ogt, j, j2);
    }
}
