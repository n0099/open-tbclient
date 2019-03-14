package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class o<E> extends k<E> {
    protected static final long kbD = ae.j(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cEQ() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void eu(long j) {
        ae.kbJ.putOrderedLong(this, kbD, j);
    }

    public o(int i) {
        super(i);
    }
}
