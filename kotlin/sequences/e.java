package kotlin.sequences;

import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e {
    public static final <T> c<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.j(aVar, "seedFunction");
        p.j(bVar, "nextFunction");
        return new b(aVar, bVar);
    }
}
