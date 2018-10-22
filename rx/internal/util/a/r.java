package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iDv = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iDx;

    public r(int i) {
        super(i);
        this.iDx = Math.min(i / 4, iDv.intValue());
    }
}
