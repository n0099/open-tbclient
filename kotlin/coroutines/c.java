package kotlin.coroutines;

import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public interface c {

    @h
    /* loaded from: classes10.dex */
    public interface b extends c {
        InterfaceC0986c<?> enT();

        @Override // kotlin.coroutines.c
        <E extends b> E get(InterfaceC0986c<E> interfaceC0986c);
    }

    @h
    /* renamed from: kotlin.coroutines.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0986c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(InterfaceC0986c<E> interfaceC0986c);

    c minusKey(InterfaceC0986c<?> interfaceC0986c);

    c plus(c cVar);

    @h
    /* loaded from: classes10.dex */
    public static final class a {
        public static c a(c cVar, c cVar2) {
            q.n(cVar2, "context");
            return cVar2 == EmptyCoroutineContext.INSTANCE ? cVar : (c) cVar2.fold(cVar, CoroutineContext$plus$1.INSTANCE);
        }
    }
}
