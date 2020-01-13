package kotlin.jvm.internal;

import java.util.Iterator;
/* loaded from: classes5.dex */
public final class h {
    public static final <T> Iterator<T> Q(T[] tArr) {
        q.j(tArr, "array");
        return new g(tArr);
    }
}
