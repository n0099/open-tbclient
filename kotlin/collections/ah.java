package kotlin.collections;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public class ah {
    public static final <T> Set<T> eMa() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> U(T... tArr) {
        kotlin.jvm.internal.p.o(tArr, "elements");
        return tArr.length > 0 ? f.T(tArr) : ag.eMa();
    }

    public static final <T> Set<T> bS(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.p.n(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
