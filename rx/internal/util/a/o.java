package rx.internal.util.a;
/* loaded from: classes16.dex */
abstract class o<E> extends k<E> {
    protected static final long qjd = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eAP() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ix(long j) {
        ae.qjj.a(this, qjd, j);
    }

    public o(int i) {
        super(i);
    }
}
