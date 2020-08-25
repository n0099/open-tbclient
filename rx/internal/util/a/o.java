package rx.internal.util.a;
/* loaded from: classes5.dex */
abstract class o<E> extends k<E> {
    protected static final long oJc = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long efj() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hd(long j) {
        ae.oJi.a(this, oJc, j);
    }

    public o(int i) {
        super(i);
    }
}
