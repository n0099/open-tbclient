package h.o.d.j;
/* loaded from: classes7.dex */
public abstract class k<E> extends m<E> {
    public static final long k = f0.a(k.class, "consumerIndex");
    public volatile long consumerIndex;

    public k(int i2) {
        super(i2);
    }

    public final boolean j(long j, long j2) {
        return f0.f68672a.c(this, k, j, j2);
    }

    public final long k() {
        return this.consumerIndex;
    }
}
