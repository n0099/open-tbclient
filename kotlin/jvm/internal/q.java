package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes9.dex */
public class q {
    private q() {
    }

    public static String P(String str, Object obj) {
        return str + obj;
    }

    public static void eBQ() {
        throw ((KotlinNullPointerException) Q(new KotlinNullPointerException()));
    }

    public static void Zz(String str) {
        throw ((UninitializedPropertyAccessException) Q(new UninitializedPropertyAccessException(str)));
    }

    public static void ZA(String str) {
        Zz("lateinit property " + str + " has not been initialized");
    }

    public static void m(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) Q(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            ZB(str);
        }
    }

    private static void ZB(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) Q(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean l(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void eBR() {
        ZC("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void ZC(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void cb(int i, String str) {
        eBR();
    }

    private static <T extends Throwable> T Q(T t) {
        return (T) c(t, q.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T c(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
