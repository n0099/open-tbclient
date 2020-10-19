package rx.internal.util.a;
/* loaded from: classes16.dex */
abstract class p<E> extends n<E> {
    private volatile long pit;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long esx() {
        return this.pit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hM(long j) {
        this.pit = j;
    }
}
