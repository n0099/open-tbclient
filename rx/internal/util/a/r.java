package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iPw = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iPy;

    public r(int i) {
        super(i);
        this.iPy = Math.min(i / 4, iPw.intValue());
    }
}
