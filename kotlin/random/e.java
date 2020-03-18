package kotlin.random;

import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class e {
    public static final int ev(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final void ew(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(l(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final String l(Object obj, Object obj2) {
        q.j(obj, "from");
        q.j(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
