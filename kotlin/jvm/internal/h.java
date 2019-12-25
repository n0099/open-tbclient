package kotlin.jvm.internal;

import java.util.Iterator;
/* loaded from: classes4.dex */
public final class h {
    public static final <T> Iterator<T> P(T[] tArr) {
        p.j(tArr, "array");
        return new g(tArr);
    }
}
