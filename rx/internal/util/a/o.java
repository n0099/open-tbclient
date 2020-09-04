package rx.internal.util.a;
/* loaded from: classes5.dex */
abstract class o<E> extends k<E> {
    protected static final long oJu = ae.l(o.class, "producerIndex");
    private volatile long producerIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final long efs() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hf(long j) {
        ae.oJA.a(this, oJu, j);
    }

    public o(int i) {
        super(i);
    }
}
