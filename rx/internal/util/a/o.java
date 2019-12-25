package rx.internal.util.a;
/* loaded from: classes4.dex */
abstract class o<E> extends k<E> {
    protected static final long niV = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dEa() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gZ(long j) {
        ae.njb.a(this, niV, j);
    }

    public o(int i) {
        super(i);
    }
}
