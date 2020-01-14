package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes5.dex */
public class q {
    private q() {
    }

    public static String I(String str, Object obj) {
        return str + obj;
    }

    public static void dJm() {
        throw ((KotlinNullPointerException) P(new KotlinNullPointerException()));
    }

    public static void RU(String str) {
        throw ((UninitializedPropertyAccessException) P(new UninitializedPropertyAccessException(str)));
    }

    public static void RV(String str) {
        RU("lateinit property " + str + " has not been initialized");
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) P(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            RW(str);
        }
    }

    private static void RW(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) P(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean h(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void dJn() {
        RX("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void RX(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void bl(int i, String str) {
        dJn();
    }

    private static <T extends Throwable> T P(T t) {
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
