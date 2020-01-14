package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class an extends am {
    public static final <T> Set<T> dJb() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> P(T... tArr) {
        kotlin.jvm.internal.q.j(tArr, "elements");
        return tArr.length > 0 ? f.O(tArr) : al.dJb();
    }
}
