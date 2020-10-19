package kotlin.sequences;

import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public class h extends g {
    public static final <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.n(aVar, "seedFunction");
        q.n(bVar, "nextFunction");
        return new b(aVar, bVar);
    }
}
