package d.g.c.c;
/* loaded from: classes6.dex */
public final class e0 {
    public static int a(int i2, double d2) {
        int max = Math.max(i2, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d2 * highestOneBit))) {
            int i3 = highestOneBit << 1;
            if (i3 > 0) {
                return i3;
            }
            return 1073741824;
        }
        return highestOneBit;
    }

    public static boolean b(int i2, int i3, double d2) {
        return ((double) i2) > d2 * ((double) i3) && i3 < 1073741824;
    }

    public static int c(int i2) {
        return (int) (Integer.rotateLeft((int) (i2 * (-862048943)), 15) * 461845907);
    }

    public static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
