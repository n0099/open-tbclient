package kotlin.collections;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class r extends q {
    public static final <T> boolean a(Iterable<? extends T> iterable, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        kotlin.jvm.internal.p.j(iterable, "$receiver");
        kotlin.jvm.internal.p.j(bVar, "predicate");
        return a(iterable, bVar, false);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: T, ? super T */
    private static final <T> boolean a(Iterable<? extends T> iterable, kotlin.jvm.a.b<? super T, Boolean> bVar, boolean z) {
        boolean z2 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                if (bVar.invoke((T) it.next()).booleanValue() == z) {
                    it.remove();
                    z2 = true;
                } else {
                    z2 = z3;
                }
            } else {
                return z3;
            }
        }
    }
}
