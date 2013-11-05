package javassist.bytecode;
/* loaded from: classes.dex */
public class a {
    public static int a(int i) {
        return (i & (-6)) | 2;
    }

    public static int b(int i) {
        return i & (-8);
    }

    public static boolean c(int i) {
        return (i & 2) != 0;
    }

    public static int a(int i, int i2) {
        return (i2 ^ (-1)) & i;
    }

    public static int d(int i) {
        return i;
    }

    public static int e(int i) {
        return i;
    }
}
