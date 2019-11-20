package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o {
    public static final <T> List<T> cMF() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> bd(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.p.h(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final kotlin.b.c g(Collection<?> collection) {
        kotlin.jvm.internal.p.i(collection, "$receiver");
        return new kotlin.b.c(0, collection.size() - 1);
    }
}
