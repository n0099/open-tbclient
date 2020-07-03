package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class o<E> extends k<E> {
    protected static final long ogu = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dPG() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gD(long j) {
        ae.ogA.a(this, ogu, j);
    }

    public o(int i) {
        super(i);
    }
}
