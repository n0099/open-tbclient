package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iQE = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iQG;

    public r(int i) {
        super(i);
        this.iQG = Math.min(i / 4, iQE.intValue());
    }
}
