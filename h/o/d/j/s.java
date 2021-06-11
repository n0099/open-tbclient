package h.o.d.j;
/* loaded from: classes8.dex */
public abstract class s<E> extends f<E> {
    public static final Integer j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public s(int i2) {
        super(i2);
        Math.min(i2 / 4, j.intValue());
    }
}
