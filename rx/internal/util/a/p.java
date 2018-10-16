package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long iDM;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cdf() {
        return this.iDM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dR(long j) {
        this.iDM = j;
    }
}
