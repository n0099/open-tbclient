package kotlin.collections;

import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class q extends p {
    public static final <T> List<T> dIU() {
        return EmptyList.INSTANCE;
    }

    public static final kotlin.b.c k(Collection<?> collection) {
        kotlin.jvm.internal.q.j(collection, "receiver$0");
        return new kotlin.b.c(0, collection.size() - 1);
    }

    public static final <T> int fz(List<? extends T> list) {
        kotlin.jvm.internal.q.j(list, "receiver$0");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> fA(List<? extends T> list) {
        kotlin.jvm.internal.q.j(list, "receiver$0");
        switch (list.size()) {
            case 0:
                return o.dIU();
            case 1:
                return o.bR(list.get(0));
            default:
                return list;
        }
    }
}
