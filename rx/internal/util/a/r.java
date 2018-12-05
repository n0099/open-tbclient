package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iMm = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iMo;

    public r(int i) {
        super(i);
        this.iMo = Math.min(i / 4, iMm.intValue());
    }
}
