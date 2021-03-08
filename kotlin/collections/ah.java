package kotlin.collections;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes14.dex */
public class ah {
    public static final <T> Set<T> eKU() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> T(T... tArr) {
        kotlin.jvm.internal.p.p(tArr, "elements");
        return tArr.length > 0 ? f.S(tArr) : ag.eKU();
    }

    public static final <T> Set<T> bU(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.p.o(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
