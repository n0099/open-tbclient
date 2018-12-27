package rx.observables;
/* loaded from: classes2.dex */
public final class b<T> {
    static final Object iQl = new Object();
    static final Object iQm = new Object();
    static final Object iQn = new Object();
    private final rx.d<? extends T> iQk;

    private b(rx.d<? extends T> dVar) {
        this.iQk = dVar;
    }

    public static <T> b<T> n(rx.d<? extends T> dVar) {
        return new b<>(dVar);
    }
}
