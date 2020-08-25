package kotlin;

import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes20.dex */
public class f {
    public static final <T> d<T> b(kotlin.jvm.a.a<? extends T> aVar) {
        q.m(aVar, "initializer");
        return new SynchronizedLazyImpl(aVar, null, 2, null);
    }
}
