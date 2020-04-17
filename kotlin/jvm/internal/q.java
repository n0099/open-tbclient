package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes7.dex */
public class q {
    private q() {
    }

    public static String M(String str, Object obj) {
        return str + obj;
    }

    public static void dDV() {
        throw ((KotlinNullPointerException) S(new KotlinNullPointerException()));
    }

    public static void Pv(String str) {
        throw ((UninitializedPropertyAccessException) S(new UninitializedPropertyAccessException(str)));
    }

    public static void Pw(String str) {
        Pv("lateinit property " + str + " has not been initialized");
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) S(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            Px(str);
        }
    }

    private static void Px(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) S(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean k(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void dDW() {
        Py("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Py(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void bz(int i, String str) {
        dDW();
    }

    private static <T extends Throwable> T S(T t) {
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
