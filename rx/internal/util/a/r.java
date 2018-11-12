package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer iFf = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int iFh;

    public r(int i) {
        super(i);
        this.iFh = Math.min(i / 4, iFf.intValue());
    }
}
