package kotlin.coroutines.experimental.jvm.internal;

import kotlin.coroutines.experimental.b;
import kotlin.coroutines.experimental.c;
import kotlin.coroutines.experimental.d;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.experimental.b<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> a(d dVar, b<? super T> bVar) {
        b<T> a;
        p.i(dVar, "context");
        p.i(bVar, "continuation");
        c cVar = (c) dVar.a(c.kuT);
        return (cVar == null || (a = cVar.a(bVar)) == null) ? bVar : a;
    }
}
