package rx.internal.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public abstract class j<E> extends l<E> {
    protected static final long pUI = ae.l(j.class, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eDj() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean S(long j, long j2) {
        return ae.pUP.a(this, pUI, j, j2);
    }
}
