package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kDL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kDN;

    public r(int i) {
        super(i);
        this.kDN = Math.min(i / 4, kDL.intValue());
    }
}
