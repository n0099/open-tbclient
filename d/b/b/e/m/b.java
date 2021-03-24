package d.b.b.e.m;
/* loaded from: classes.dex */
public abstract class b {
    public static boolean a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    public static double b(String str, double d2) {
        if (str == null) {
            return d2;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return d2;
        }
    }

    public static float c(String str, float f2) {
        if (str == null) {
            return f2;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f2;
        }
    }

    public static int d(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int e(String str, int i, int i2) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str, i2);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long f(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }
}
