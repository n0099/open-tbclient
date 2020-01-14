package rx.internal.util.a;
/* loaded from: classes5.dex */
abstract class o<E> extends k<E> {
    protected static final long nRX = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dIm() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hx(long j) {
        ae.nSd.a(this, nRX, j);
    }

    public o(int i) {
        super(i);
    }
}
