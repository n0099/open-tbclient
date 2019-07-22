package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class p<E> extends n<E> {
    private volatile long kAP;

    public p(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long cQf() {
        return this.kAP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fc(long j) {
        this.kAP = j;
    }
}
