package kotlin;

import kotlin.jvm.internal.p;
@e
/* loaded from: classes6.dex */
public final class d {
    public static final <T> c<T> b(kotlin.jvm.a.a<? extends T> aVar) {
        p.o(aVar, "initializer");
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }
}
