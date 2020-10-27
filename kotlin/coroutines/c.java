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
        InterfaceC1058c<?> exS();

        @Override // kotlin.coroutines.c
        <E extends b> E get(InterfaceC1058c<E> interfaceC1058c);
    }

    @h
    /* renamed from: kotlin.coroutines.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1058c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(InterfaceC1058c<E> interfaceC1058c);

    c minusKey(InterfaceC1058c<?> interfaceC1058c);

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
