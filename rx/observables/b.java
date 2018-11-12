package rx.observables;
/* loaded from: classes2.dex */
public final class b<T> {
    static final Object iFU = new Object();
    static final Object iFV = new Object();
    static final Object iFW = new Object();
    private final rx.d<? extends T> iFT;

    private b(rx.d<? extends T> dVar) {
        this.iFT = dVar;
    }

    public static <T> b<T> n(rx.d<? extends T> dVar) {
        return new b<>(dVar);
    }
}
