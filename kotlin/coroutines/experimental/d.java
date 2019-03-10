package kotlin.coroutines.experimental;
/* loaded from: classes2.dex */
public interface d {

    /* loaded from: classes2.dex */
    public static final class a {
    }

    /* loaded from: classes2.dex */
    public interface b extends d {
        @Override // kotlin.coroutines.experimental.d
        <E extends b> E a(c<E> cVar);

        c<?> cCx();
    }

    /* loaded from: classes2.dex */
    public interface c<E extends b> {
    }

    <R> R a(R r, kotlin.jvm.a.c<? super R, ? super b, ? extends R> cVar);

    <E extends b> E a(c<E> cVar);

    d b(c<?> cVar);
}
