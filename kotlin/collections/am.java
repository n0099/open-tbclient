package kotlin.collections;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class am {
    public static final <T> Set<T> bS(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.q.i(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
