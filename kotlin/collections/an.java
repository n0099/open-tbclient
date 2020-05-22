package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class an extends am {
    public static final <T> Set<T> dLB() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> S(T... tArr) {
        kotlin.jvm.internal.q.m(tArr, "elements");
        return tArr.length > 0 ? f.R(tArr) : al.dLB();
    }
}
