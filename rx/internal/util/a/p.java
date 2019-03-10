package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kbM;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cEQ() {
        return this.kbM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ev(long j) {
        this.kbM = j;
    }
}
