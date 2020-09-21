package kotlin.collections;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes5.dex */
public class v extends u {
    public static final <T> boolean a(Iterable<? extends T> iterable, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        kotlin.jvm.internal.q.m(iterable, "receiver$0");
        kotlin.jvm.internal.q.m(bVar, "predicate");
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
