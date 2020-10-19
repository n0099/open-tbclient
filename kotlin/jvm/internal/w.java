package kotlin.jvm.internal;
/* loaded from: classes10.dex */
public class w {
    private static <T extends Throwable> T Q(T t) {
        return (T) q.c(t, w.class.getName());
    }

    public static void o(Object obj, String str) {
        XB((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void XB(String str) {
        throw a(new ClassCastException(str));
    }

    public static ClassCastException a(ClassCastException classCastException) {
        throw ((ClassCastException) Q(classCastException));
    }

    public static int bS(Object obj) {
        if (obj instanceof p) {
            return ((p) obj).getArity();
        }
        if (obj instanceof kotlin.jvm.a.a) {
            return 0;
        }
        if (obj instanceof kotlin.jvm.a.b) {
            return 1;
        }
        if (obj instanceof kotlin.jvm.a.m) {
            return 2;
        }
        if (obj instanceof kotlin.jvm.a.q) {
            return 3;
        }
        if (obj instanceof kotlin.jvm.a.r) {
            return 4;
        }
        if (obj instanceof kotlin.jvm.a.s) {
            return 5;
        }
        if (obj instanceof kotlin.jvm.a.t) {
            return 6;
        }
        if (obj instanceof kotlin.jvm.a.u) {
            return 7;
        }
        if (obj instanceof kotlin.jvm.a.v) {
            return 8;
        }
        if (obj instanceof kotlin.jvm.a.w) {
            return 9;
        }
        if (obj instanceof kotlin.jvm.a.c) {
            return 10;
        }
        if (obj instanceof kotlin.jvm.a.d) {
            return 11;
        }
        if (obj instanceof kotlin.jvm.a.e) {
            return 12;
        }
        if (obj instanceof kotlin.jvm.a.f) {
            return 13;
        }
        if (obj instanceof kotlin.jvm.a.g) {
            return 14;
        }
        if (obj instanceof kotlin.jvm.a.h) {
            return 15;
        }
        if (obj instanceof kotlin.jvm.a.i) {
            return 16;
        }
        if (obj instanceof kotlin.jvm.a.j) {
            return 17;
        }
        if (obj instanceof kotlin.jvm.a.k) {
            return 18;
        }
        if (obj instanceof kotlin.jvm.a.l) {
            return 19;
        }
        if (obj instanceof kotlin.jvm.a.n) {
            return 20;
        }
        if (obj instanceof kotlin.jvm.a.o) {
            return 21;
        }
        if (obj instanceof kotlin.jvm.a.p) {
            return 22;
        }
        return -1;
    }

    public static boolean j(Object obj, int i) {
        return (obj instanceof kotlin.c) && bS(obj) == i;
    }

    public static Object k(Object obj, int i) {
        if (obj != null && !j(obj, i)) {
            o(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }
}
