package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kEd;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cPp() {
        return this.kEd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ez(long j) {
        this.kEd = j;
    }
}
