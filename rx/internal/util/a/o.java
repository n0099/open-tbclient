package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class o<E> extends k<E> {
    protected static final long nUL = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dJW() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hw(long j) {
        ae.nUR.a(this, nUL, j);
    }

    public o(int i) {
        super(i);
    }
}
