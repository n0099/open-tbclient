package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class o<E> extends k<E> {
    protected static final long opf = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dTg() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gQ(long j) {
        ae.opl.a(this, opf, j);
    }

    public o(int i) {
        super(i);
    }
}
