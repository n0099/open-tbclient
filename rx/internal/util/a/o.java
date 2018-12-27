package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class o<E> extends k<E> {
    protected static final long iPN = ae.j(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cfs() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dX(long j) {
        ae.iPT.putOrderedLong(this, iPN, j);
    }

    public o(int i) {
        super(i);
    }
}
