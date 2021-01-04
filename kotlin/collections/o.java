package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public class o {
    public static final <T> List<T> eLS() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> bR(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.p.n(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final kotlin.b.h n(Collection<?> collection) {
        kotlin.jvm.internal.p.o(collection, "$receiver");
        return new kotlin.b.h(0, collection.size() - 1);
    }

    public static final <T> int hh(List<? extends T> list) {
        kotlin.jvm.internal.p.o(list, "$receiver");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> hi(List<? extends T> list) {
        kotlin.jvm.internal.p.o(list, "$receiver");
        switch (list.size()) {
            case 0:
                return n.eLS();
            case 1:
                return n.bR(list.get(0));
            default:
                return list;
        }
    }
}
