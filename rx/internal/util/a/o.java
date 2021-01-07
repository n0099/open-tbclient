package rx.internal.util.a;
/* loaded from: classes15.dex */
abstract class o<E> extends k<E> {
    protected static final long qxR = ae.m(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eLU() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void jA(long j) {
        ae.qxX.a(this, qxR, j);
    }

    public o(int i) {
        super(i);
    }
}
