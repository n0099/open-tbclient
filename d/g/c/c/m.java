package d.g.c.c;
/* loaded from: classes6.dex */
public final class m {
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 != null) {
        } else {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    public static int b(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    public static long c(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j);
    }

    public static void d(int i2, String str) {
        if (i2 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i2);
    }

    public static void e(boolean z) {
        d.g.c.a.n.x(z, "no calls to next() since the last call to remove()");
    }
}
