package h.o.d.k;
/* loaded from: classes7.dex */
public abstract class s<E> extends f<E> {
    public static final Integer j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public s(int i) {
        super(i);
        Math.min(i / 4, j.intValue());
    }
}
