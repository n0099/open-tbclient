package rx.observables;
/* loaded from: classes2.dex */
public final class b<T> {
    static final Object iNb = new Object();
    static final Object iNc = new Object();
    static final Object iNd = new Object();
    private final rx.d<? extends T> iNa;

    private b(rx.d<? extends T> dVar) {
        this.iNa = dVar;
    }

    public static <T> b<T> n(rx.d<? extends T> dVar) {
        return new b<>(dVar);
    }
}
