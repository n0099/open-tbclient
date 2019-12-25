package rx.internal.util.a;
/* loaded from: classes4.dex */
abstract class p<E> extends n<E> {
    private volatile long niW;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dGW() {
        return this.niW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ha(long j) {
        this.niW = j;
    }
}
