package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer ksV = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int ksX;

    public r(int i) {
        super(i);
        this.ksX = Math.min(i / 4, ksV.intValue());
    }
}
