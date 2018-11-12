package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class o<E> extends k<E> {
    protected static final long iFw = ae.j(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ccz() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dL(long j) {
        ae.iFC.putOrderedLong(this, iFw, j);
    }

    public o(int i) {
        super(i);
    }
}
