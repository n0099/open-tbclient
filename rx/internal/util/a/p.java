package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long ktm;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cMo() {
        return this.ktm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void eT(long j) {
        this.ktm = j;
    }
}
