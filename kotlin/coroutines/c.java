package kotlin.coroutines;

import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public interface c {

    @h
    /* loaded from: classes7.dex */
    public interface b extends c {
        InterfaceC0877c<?> dLE();

        @Override // kotlin.coroutines.c
        <E extends b> E get(InterfaceC0877c<E> interfaceC0877c);
    }

    @h
    /* renamed from: kotlin.coroutines.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0877c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(InterfaceC0877c<E> interfaceC0877c);

    c minusKey(InterfaceC0877c<?> interfaceC0877c);

    c plus(c cVar);

    @h
    /* loaded from: classes7.dex */
    public static final class a {
        public static c a(c cVar, c cVar2) {
            q.m(cVar2, "context");
            return cVar2 == EmptyCoroutineContext.INSTANCE ? cVar : (c) cVar2.fold(cVar, CoroutineContext$plus$1.INSTANCE);
        }
    }
}
