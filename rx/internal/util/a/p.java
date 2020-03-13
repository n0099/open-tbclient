package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class p<E> extends n<E> {
    private volatile long nSZ;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dOP() {
        return this.nSZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hw(long j) {
        this.nSZ = j;
    }
}
