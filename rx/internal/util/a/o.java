package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class o<E> extends k<E> {
    protected static final long oph = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dTh() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gQ(long j) {
        ae.opn.a(this, oph, j);
    }

    public o(int i) {
        super(i);
    }
}
