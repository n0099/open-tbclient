package kotlin.sequences;

import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes20.dex */
public class h extends g {
    public static final <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.m(aVar, "seedFunction");
        q.m(bVar, "nextFunction");
        return new b(aVar, bVar);
    }
}
