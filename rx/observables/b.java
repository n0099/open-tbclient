package rx.observables;
/* loaded from: classes2.dex */
public final class b<T> {
    static final Object iEj = new Object();
    static final Object iEk = new Object();
    static final Object iEl = new Object();
    private final rx.d<? extends T> iEi;

    private b(rx.d<? extends T> dVar) {
        this.iEi = dVar;
    }

    public static <T> b<T> n(rx.d<? extends T> dVar) {
        return new b<>(dVar);
    }
}
