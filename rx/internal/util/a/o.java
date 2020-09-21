package rx.internal.util.a;
/* loaded from: classes7.dex */
abstract class o<E> extends k<E> {
    protected static final long oSZ = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ejp() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ht(long j) {
        ae.oTf.a(this, oSZ, j);
    }

    public o(int i) {
        super(i);
    }
}
