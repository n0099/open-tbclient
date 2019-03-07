package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kbt;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cEG() {
        return this.kbt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ev(long j) {
        this.kbt = j;
    }
}
