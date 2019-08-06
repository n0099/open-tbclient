package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kBV;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cQA() {
        return this.kBV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fc(long j) {
        this.kBV = j;
    }
}
