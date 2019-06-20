package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer ksY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kta;

    public r(int i) {
        super(i);
        this.kta = Math.min(i / 4, ksY.intValue());
    }
}
