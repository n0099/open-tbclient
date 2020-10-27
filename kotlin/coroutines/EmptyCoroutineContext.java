package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.c;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class EmptyCoroutineContext implements Serializable, c {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.c
    public <E extends c.b> E get(c.InterfaceC1058c<E> interfaceC1058c) {
        q.n(interfaceC1058c, "key");
        return null;
    }

    @Override // kotlin.coroutines.c
    public <R> R fold(R r, m<? super R, ? super c.b, ? extends R> mVar) {
        q.n(mVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.c
    public c plus(c cVar) {
        q.n(cVar, "context");
        return cVar;
    }

    @Override // kotlin.coroutines.c
    public c minusKey(c.InterfaceC1058c<?> interfaceC1058c) {
        q.n(interfaceC1058c, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
