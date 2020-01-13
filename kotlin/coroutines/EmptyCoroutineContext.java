package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.c;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class EmptyCoroutineContext implements Serializable, c {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.c
    public <E extends c.b> E get(c.InterfaceC0762c<E> interfaceC0762c) {
        q.j(interfaceC0762c, "key");
        return null;
    }

    @Override // kotlin.coroutines.c
    public <R> R fold(R r, m<? super R, ? super c.b, ? extends R> mVar) {
        q.j(mVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.c
    public c plus(c cVar) {
        q.j(cVar, "context");
        return cVar;
    }

    @Override // kotlin.coroutines.c
    public c minusKey(c.InterfaceC0762c<?> interfaceC0762c) {
        q.j(interfaceC0762c, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
