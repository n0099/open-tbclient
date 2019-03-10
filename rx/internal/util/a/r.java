package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer kbu = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int kbw;

    public r(int i) {
        super(i);
        this.kbw = Math.min(i / 4, kbu.intValue());
    }
}
