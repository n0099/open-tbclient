package kotlin.coroutines;

import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public interface c {

    /* loaded from: classes5.dex */
    public interface b extends c {
        InterfaceC0762c<?> dJc();

        @Override // kotlin.coroutines.c
        <E extends b> E get(InterfaceC0762c<E> interfaceC0762c);
    }

    /* renamed from: kotlin.coroutines.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0762c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(InterfaceC0762c<E> interfaceC0762c);

    c minusKey(InterfaceC0762c<?> interfaceC0762c);

    c plus(c cVar);

    /* loaded from: classes5.dex */
    public static final class a {
        public static c a(c cVar, c cVar2) {
            q.j(cVar2, "context");
            return cVar2 == EmptyCoroutineContext.INSTANCE ? cVar : (c) cVar2.fold(cVar, CoroutineContext$plus$1.INSTANCE);
        }
    }
}
