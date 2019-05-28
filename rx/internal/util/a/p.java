package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long ktn;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cMq() {
        return this.ktn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void eT(long j) {
        this.ktn = j;
    }
}
