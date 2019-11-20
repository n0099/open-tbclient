package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class o<E> extends k<E> {
    protected static final long kEc = ae.i(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cPm() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ey(long j) {
        ae.kEi.putOrderedLong(this, kEc, j);
    }

    public o(int i) {
        super(i);
    }
}
