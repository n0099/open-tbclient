package rx.internal.util.a;
/* loaded from: classes15.dex */
abstract class o<E> extends k<E> {
    protected static final long qwj = ae.m(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eLq() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void jx(long j) {
        ae.qwp.a(this, qwj, j);
    }

    public o(int i) {
        super(i);
    }
}
