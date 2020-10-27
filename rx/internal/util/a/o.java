package rx.internal.util.a;
/* loaded from: classes16.dex */
abstract class o<E> extends k<E> {
    protected static final long pZI = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long exa() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ib(long j) {
        ae.pZO.a(this, pZI, j);
    }

    public o(int i) {
        super(i);
    }
}
