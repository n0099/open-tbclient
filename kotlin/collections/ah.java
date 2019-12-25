package kotlin.collections;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class ah {
    public static final <T> Set<T> dEJ() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> O(T... tArr) {
        kotlin.jvm.internal.p.j(tArr, "elements");
        return tArr.length > 0 ? f.N(tArr) : ag.dEJ();
    }

    public static final <T> Set<T> bO(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.p.i(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
