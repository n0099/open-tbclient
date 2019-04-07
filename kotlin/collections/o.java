package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o {
    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> bg(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.p.j(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final kotlin.b.c i(Collection<?> collection) {
        kotlin.jvm.internal.p.k(collection, "$receiver");
        return new kotlin.b.c(0, collection.size() - 1);
    }
}
