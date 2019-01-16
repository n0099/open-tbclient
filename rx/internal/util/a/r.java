package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iQD = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iQF;

    public r(int i) {
        super(i);
        this.iQF = Math.min(i / 4, iQD.intValue());
    }
}
