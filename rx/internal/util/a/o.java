package rx.internal.util.a;
/* loaded from: classes5.dex */
abstract class o<E> extends k<E> {
    protected static final long qDT = ae.m(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eKC() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void jD(long j) {
        ae.qDZ.a(this, qDT, j);
    }

    public o(int i) {
        super(i);
    }
}
