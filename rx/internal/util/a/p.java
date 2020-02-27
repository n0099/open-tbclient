package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class p<E> extends n<E> {
    private volatile long nSM;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dOM() {
        return this.nSM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hw(long j) {
        this.nSM = j;
    }
}
