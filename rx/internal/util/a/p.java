package rx.internal.util.a;
/* loaded from: classes6.dex */
abstract class p<E> extends n<E> {
    private volatile long ogv;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dVa() {
        return this.ogv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void gE(long j) {
        this.ogv = j;
    }
}
