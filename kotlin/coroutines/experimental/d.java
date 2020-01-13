package kotlin.coroutines.experimental;

import kotlin.jvm.a.m;
/* loaded from: classes5.dex */
public interface d {

    /* loaded from: classes5.dex */
    public static final class a {
    }

    /* loaded from: classes5.dex */
    public interface b extends d {
        @Override // kotlin.coroutines.experimental.d
        <E extends b> E a(c<E> cVar);

        c<?> dJd();
    }

    /* loaded from: classes5.dex */
    public interface c<E extends b> {
    }

    <E extends b> E a(c<E> cVar);

    d b(c<?> cVar);

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);
}
