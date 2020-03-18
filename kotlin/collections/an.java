package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class an extends am {
    public static final <T> Set<T> dKL() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> Q(T... tArr) {
        kotlin.jvm.internal.q.j(tArr, "elements");
        return tArr.length > 0 ? f.P(tArr) : al.dKL();
    }
}
