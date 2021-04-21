package d.h.c.c;
/* loaded from: classes6.dex */
public final class e0 {
    public static int a(int i, double d2) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d2 * highestOneBit))) {
            int i2 = highestOneBit << 1;
            if (i2 > 0) {
                return i2;
            }
            return 1073741824;
        }
        return highestOneBit;
    }

    public static boolean b(int i, int i2, double d2) {
        return ((double) i) > d2 * ((double) i2) && i2 < 1073741824;
    }

    public static int c(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
