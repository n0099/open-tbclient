package rx.internal.util.a;
/* loaded from: classes5.dex */
abstract class p<E> extends n<E> {
    private volatile long nRT;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dNx() {
        return this.nRT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hy(long j) {
        this.nRT = j;
    }
}
