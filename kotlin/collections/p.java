package kotlin.collections;

import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public class p {
    public static final <T> List<T> bQ(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.q.m(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
