package rx.internal.util.a;
/* loaded from: classes14.dex */
abstract class p<E> extends n<E> {
    private volatile long qtr;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eLj() {
        return this.qtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void jB(long j) {
        this.qtr = j;
    }
}
