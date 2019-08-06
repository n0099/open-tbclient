package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kBD = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kBF;

    public r(int i) {
        super(i);
        this.kBF = Math.min(i / 4, kBD.intValue());
    }
}
