package rx.internal.util.a;
/* loaded from: classes4.dex */
abstract class o<E> extends k<E> {
    protected static final long qEv = ae.m(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eKk() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void jC(long j) {
        ae.qEB.a(this, qEv, j);
    }

    public o(int i) {
        super(i);
    }
}
