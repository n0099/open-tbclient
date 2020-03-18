package kotlin.jvm.internal;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes7.dex */
public final class h {
    public static final <T> Iterator<T> R(T[] tArr) {
        q.j(tArr, "array");
        return new g(tArr);
    }
}
