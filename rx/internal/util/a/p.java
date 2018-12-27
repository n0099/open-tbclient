package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long iPO;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cfv() {
        return this.iPO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dY(long j) {
        this.iPO = j;
    }
}
