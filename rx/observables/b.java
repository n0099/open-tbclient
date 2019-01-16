package rx.observables;
/* loaded from: classes2.dex */
public final class b<T> {
    static final Object iRs = new Object();
    static final Object iRt = new Object();
    static final Object iRu = new Object();
    private final rx.d<? extends T> iRr;

    private b(rx.d<? extends T> dVar) {
        this.iRr = dVar;
    }

    public static <T> b<T> n(rx.d<? extends T> dVar) {
        return new b<>(dVar);
    }
}
