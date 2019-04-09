package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kaF = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kaH;

    public r(int i) {
        super(i);
        this.kaH = Math.min(i / 4, kaF.intValue());
    }
}
