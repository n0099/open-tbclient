package kotlin.collections;

import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes5.dex */
public class q extends p {
    public static final <T> List<T> ejX() {
        return EmptyList.INSTANCE;
    }

    public static final kotlin.b.h o(Collection<?> collection) {
        kotlin.jvm.internal.q.m(collection, "receiver$0");
        return new kotlin.b.h(0, collection.size() - 1);
    }

    public static final <T> int gf(List<? extends T> list) {
        kotlin.jvm.internal.q.m(list, "receiver$0");
        return list.size() - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> gg(List<? extends T> list) {
        kotlin.jvm.internal.q.m(list, "receiver$0");
        switch (list.size()) {
            case 0:
                return o.ejX();
            case 1:
                return o.bN(list.get(0));
            default:
                return list;
        }
    }
}
