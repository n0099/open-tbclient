package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kAx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kAz;

    public r(int i) {
        super(i);
        this.kAz = Math.min(i / 4, kAx.intValue());
    }
}
