package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long iME;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ceE() {
        return this.iME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dT(long j) {
        this.iME = j;
    }
}
