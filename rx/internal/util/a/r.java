package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kbb = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kbd;

    public r(int i) {
        super(i);
        this.kbd = Math.min(i / 4, kbb.intValue());
    }
}
