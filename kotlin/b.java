package kotlin;

import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public static final <T> a<T> a(kotlin.jvm.a.a<? extends T> aVar) {
        p.h((Object) aVar, "initializer");
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }
}
