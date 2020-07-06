package rx.internal.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class j<E> extends l<E> {
    protected static final long ogw = ae.l(j.class, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dPL() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean W(long j, long j2) {
        return ae.ogD.a(this, ogw, j, j2);
    }
}
