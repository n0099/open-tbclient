package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p extends o {
    public static final <T> int a(Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.p.j(iterable, "$receiver");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    private static final <T> boolean l(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    public static final <T> Collection<T> b(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.j(iterable, "$receiver");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            return l((Collection) iterable) ? n.e(iterable) : (Collection) iterable;
        }
        return n.e(iterable);
    }
}
