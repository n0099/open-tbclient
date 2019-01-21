package rx.observables;
/* loaded from: classes2.dex */
public final class b<T> {
    static final Object iRt = new Object();
    static final Object iRu = new Object();
    static final Object iRv = new Object();
    private final rx.d<? extends T> iRs;

    private b(rx.d<? extends T> dVar) {
        this.iRs = dVar;
    }

    public static <T> b<T> n(rx.d<? extends T> dVar) {
        return new b<>(dVar);
    }
}
