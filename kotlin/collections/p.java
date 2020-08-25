package kotlin.collections;

import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes20.dex */
public class p {
    public static final <T> List<T> bL(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.q.l((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
