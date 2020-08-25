package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes20.dex */
public class r extends q {
    public static final <T> int a(Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.q.m(iterable, "receiver$0");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    private static final <T> boolean p(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    public static final <T> Collection<T> c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.q.m(iterable, "receiver$0");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            return p((Collection) iterable) ? o.f(iterable) : (Collection) iterable;
        }
        return o.f(iterable);
    }
}
