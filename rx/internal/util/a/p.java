package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kaW;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cEI() {
        return this.kaW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void eu(long j) {
        this.kaW = j;
    }
}
