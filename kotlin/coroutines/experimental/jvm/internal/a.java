package kotlin.coroutines.experimental.jvm.internal;

import kotlin.coroutines.experimental.b;
import kotlin.coroutines.experimental.c;
import kotlin.coroutines.experimental.d;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes17.dex */
public final class a {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.experimental.b<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> a(d dVar, b<? super T> bVar) {
        b<T> a2;
        p.o(dVar, "context");
        p.o(bVar, "continuation");
        c cVar = (c) dVar.a(c.pKp);
        return (cVar == null || (a2 = cVar.a(bVar)) == null) ? bVar : a2;
    }
}
