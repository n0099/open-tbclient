package kotlin.collections;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes20.dex */
public class an extends am {
    public static final <T> Set<T> efY() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> R(T... tArr) {
        kotlin.jvm.internal.q.m(tArr, "elements");
        return tArr.length > 0 ? f.Q(tArr) : al.efY();
    }
}
