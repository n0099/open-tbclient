package d.a.c.e.m;
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

    public static int d(String str, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int e(String str, int i2, int i3) {
        if (str == null) {
            return i2;
        }
        try {
            return Integer.parseInt(str, i3);
        } catch (Exception unused) {
            return i2;
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
