package rx.internal.util.a;
/* loaded from: classes2.dex */
abstract class r<E> extends f<E> {
    private static final Integer ksU = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int ksW;

    public r(int i) {
        super(i);
        this.ksW = Math.min(i / 4, ksU.intValue());
    }
}
