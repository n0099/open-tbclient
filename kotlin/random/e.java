package kotlin.random;

import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class e {
    public static final int dL(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final void dM(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(m(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final String m(Object obj, Object obj2) {
        q.m(obj, "from");
        q.m(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
