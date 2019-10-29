package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kEC = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kEE;

    public r(int i) {
        super(i);
        this.kEE = Math.min(i / 4, kEC.intValue());
    }
}
