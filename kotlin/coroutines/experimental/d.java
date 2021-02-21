package kotlin.coroutines.experimental;
@kotlin.e
/* loaded from: classes6.dex */
public interface d {

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a {
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public interface b extends d {
        @Override // kotlin.coroutines.experimental.d
        <E extends b> E a(c<E> cVar);

        c<?> eLp();
    }

    @kotlin.e
    /* loaded from: classes6.dex */
    public interface c<E extends b> {
    }

    <R> R a(R r, kotlin.jvm.a.c<? super R, ? super b, ? extends R> cVar);

    <E extends b> E a(c<E> cVar);

    d b(c<?> cVar);
}
