package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class p<E> extends n<E> {
    private volatile long opi;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dYB() {
        return this.opi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gR(long j) {
        this.opi = j;
    }
}
