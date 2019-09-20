package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kDV = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kDX;

    public r(int i) {
        super(i);
        this.kDX = Math.min(i / 4, kDV.intValue());
    }
}
