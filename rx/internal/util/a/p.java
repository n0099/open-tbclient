package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kEn;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cRm() {
        return this.kEn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ff(long j) {
        this.kEn = j;
    }
}
