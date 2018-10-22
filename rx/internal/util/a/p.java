package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long iDN;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cdf() {
        return this.iDN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dR(long j) {
        this.iDN = j;
    }
}
