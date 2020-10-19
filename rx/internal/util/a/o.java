package rx.internal.util.a;
/* loaded from: classes16.dex */
abstract class o<E> extends k<E> {
    protected static final long pis = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ena() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hL(long j) {
        ae.piy.a(this, pis, j);
    }

    public o(int i) {
        super(i);
    }
}
