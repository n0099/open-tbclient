package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class o<E> extends k<E> {
    protected static final long iDM = ae.j(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cdc() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dQ(long j) {
        ae.iDS.putOrderedLong(this, iDM, j);
    }

    public o(int i) {
        super(i);
    }
}
