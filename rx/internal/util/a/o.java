package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class o<E> extends k<E> {
    protected static final long nKG = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dLa() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gy(long j) {
        ae.nKM.a(this, nKG, j);
    }

    public o(int i) {
        super(i);
    }
}
