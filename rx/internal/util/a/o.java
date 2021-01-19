package rx.internal.util.a;
/* loaded from: classes14.dex */
abstract class o<E> extends k<E> {
    protected static final long qtq = ae.m(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eIe() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void jA(long j) {
        ae.qtw.a(this, qtq, j);
    }

    public o(int i) {
        super(i);
    }
}
