package rx.internal.util.a;
/* loaded from: classes14.dex */
abstract class o<E> extends k<E> {
    protected static final long qkG = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eAQ() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void iA(long j) {
        ae.qkM.a(this, qkG, j);
    }

    public o(int i) {
        super(i);
    }
}
