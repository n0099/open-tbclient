package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes14.dex */
public class o {
    public static final <T> List<T> eKM() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> bT(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.p.o(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final kotlin.b.h o(Collection<?> collection) {
        kotlin.jvm.internal.p.p(collection, "$receiver");
        return new kotlin.b.h(0, collection.size() - 1);
    }

    public static final <T> int hf(List<? extends T> list) {
        kotlin.jvm.internal.p.p(list, "$receiver");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> hg(List<? extends T> list) {
        kotlin.jvm.internal.p.p(list, "$receiver");
        switch (list.size()) {
            case 0:
                return n.eKM();
            case 1:
                return n.bT(list.get(0));
            default:
                return list;
        }
    }
}
