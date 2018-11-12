package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long iFx;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ccC() {
        return this.iFx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dM(long j) {
        this.iFx = j;
    }
}
