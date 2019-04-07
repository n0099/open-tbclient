package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kaE = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kaG;

    public r(int i) {
        super(i);
        this.kaG = Math.min(i / 4, kaE.intValue());
    }
}
