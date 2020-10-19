package kotlin.collections;

import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public class q extends p {
    public static final <T> List<T> enJ() {
        return EmptyList.INSTANCE;
    }

    public static final kotlin.b.h o(Collection<?> collection) {
        kotlin.jvm.internal.q.n(collection, "receiver$0");
        return new kotlin.b.h(0, collection.size() - 1);
    }

    public static final <T> int gi(List<? extends T> list) {
        kotlin.jvm.internal.q.n(list, "receiver$0");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> gj(List<? extends T> list) {
        kotlin.jvm.internal.q.n(list, "receiver$0");
        switch (list.size()) {
            case 0:
                return o.enJ();
            case 1:
                return o.bQ(list.get(0));
            default:
                return list;
        }
    }
}
