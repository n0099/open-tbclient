package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class o {
    public static final <T> List<T> dEC() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> bN(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.p.i(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final kotlin.b.c k(Collection<?> collection) {
        kotlin.jvm.internal.p.j(collection, "$receiver");
        return new kotlin.b.c(0, collection.size() - 1);
    }

    public static final <T> int fy(List<? extends T> list) {
        kotlin.jvm.internal.p.j(list, "$receiver");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> fz(List<? extends T> list) {
        kotlin.jvm.internal.p.j(list, "$receiver");
        switch (list.size()) {
            case 0:
                return n.dEC();
            case 1:
                return n.bN(list.get(0));
            default:
                return list;
        }
    }
}
