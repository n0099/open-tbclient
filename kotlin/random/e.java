package kotlin.random;

import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class e {
    public static final int er(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final void es(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(m(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final String m(Object obj, Object obj2) {
        q.j(obj, "from");
        q.j(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }
}
