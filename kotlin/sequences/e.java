package kotlin.sequences;

import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes17.dex */
public class e {
    public static final <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.o(aVar, "seedFunction");
        p.o(bVar, "nextFunction");
        return new b(aVar, bVar);
    }
}
