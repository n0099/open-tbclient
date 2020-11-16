package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes9.dex */
public class an extends am {
    public static final <T> Set<T> eBF() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> R(T... tArr) {
        kotlin.jvm.internal.q.n(tArr, "elements");
        return tArr.length > 0 ? f.Q(tArr) : al.eBF();
    }
}
