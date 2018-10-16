package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iDu = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iDw;

    public r(int i) {
        super(i);
        this.iDw = Math.min(i / 4, iDu.intValue());
    }
}
