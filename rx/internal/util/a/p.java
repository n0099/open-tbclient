package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kbE;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cET() {
        return this.kbE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ev(long j) {
        this.kbE = j;
    }
}
