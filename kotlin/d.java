package kotlin;

import kotlin.jvm.internal.p;
@e
/* loaded from: classes14.dex */
public final class d {
    public static final <T> c<T> b(kotlin.jvm.a.a<? extends T> aVar) {
        p.p(aVar, "initializer");
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }
}
