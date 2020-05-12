package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class an extends am {
    public static final <T> Set<T> dDH() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> R(T... tArr) {
        kotlin.jvm.internal.q.j(tArr, "elements");
        return tArr.length > 0 ? f.Q(tArr) : al.dDH();
    }
}
