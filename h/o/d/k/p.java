package h.o.d.k;
/* loaded from: classes7.dex */
public abstract class p<E> extends l<E> {
    public static final long j = f0.a(p.class, "producerIndex");
    public volatile long producerIndex;

    public p(int i) {
        super(i);
    }

    public final long h() {
        return this.producerIndex;
    }

    public final void i(long j2) {
        f0.f69129a.i(this, j, j2);
    }
}
