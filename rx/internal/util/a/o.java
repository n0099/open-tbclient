package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class o<E> extends k<E> {
    protected static final long kaW = ae.j(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cEF() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void et(long j) {
        ae.kbc.putOrderedLong(this, kaW, j);
    }

    public o(int i) {
        super(i);
    }
}
