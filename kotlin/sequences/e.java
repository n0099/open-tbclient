package kotlin.sequences;

import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes14.dex */
public class e {
    public static final <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.p(aVar, "seedFunction");
        p.p(bVar, "nextFunction");
        return new b(aVar, bVar);
    }
}
