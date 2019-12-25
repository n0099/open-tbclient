package kotlin;

import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class d {
    public static final <T> c<T> b(kotlin.jvm.a.a<? extends T> aVar) {
        p.j(aVar, "initializer");
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }
}
