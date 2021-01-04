package rx.internal.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public abstract class j<E> extends l<E> {
    protected static final long qwi = ae.m(j.class, "consumerIndex");
    private volatile long consumerIndex;

    public j(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eLr() {
        return this.consumerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean X(long j, long j2) {
        return ae.qwp.a(this, qwi, j, j2);
    }
}
