package kotlin.jvm.internal;

import java.util.Iterator;
/* loaded from: classes2.dex */
public final class h {
    public static final <T> Iterator<T> O(T[] tArr) {
        p.k(tArr, "array");
        return new g(tArr);
    }
}
