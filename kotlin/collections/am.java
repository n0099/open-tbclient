package kotlin.collections;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class am {
    public static final <T> Set<T> bJ(T t) {
        Set<T> singleton = Collections.singleton(t);
        kotlin.jvm.internal.q.l((Object) singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }
}
