package kotlin.coroutines.experimental.jvm.internal;

import kotlin.coroutines.experimental.b;
import kotlin.coroutines.experimental.c;
import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class a {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.experimental.b<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> a(d dVar, b<? super T> bVar) {
        b<T> a;
        q.j(dVar, "context");
        q.j(bVar, "continuation");
        c cVar = (c) dVar.a(c.nDS);
        return (cVar == null || (a = cVar.a(bVar)) == null) ? bVar : a;
    }
}
