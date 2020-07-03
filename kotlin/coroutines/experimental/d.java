package kotlin.coroutines.experimental;

import kotlin.h;
import kotlin.jvm.a.m;
@h
/* loaded from: classes7.dex */
public interface d {

    @h
    /* loaded from: classes7.dex */
    public static final class a {
    }

    @h
    /* loaded from: classes7.dex */
    public interface b extends d {
        @Override // kotlin.coroutines.experimental.d
        <E extends b> E a(c<E> cVar);

        c<?> dQz();
    }

    @h
    /* loaded from: classes7.dex */
    public interface c<E extends b> {
    }

    <E extends b> E a(c<E> cVar);

    d b(c<?> cVar);

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);
}
