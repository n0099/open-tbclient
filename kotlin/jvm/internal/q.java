package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes7.dex */
public class q {
    private q() {
    }

    public static String P(String str, Object obj) {
        return str + obj;
    }

    public static void dUh() {
        throw ((KotlinNullPointerException) R(new KotlinNullPointerException()));
    }

    public static void Td(String str) {
        throw ((UninitializedPropertyAccessException) R(new UninitializedPropertyAccessException(str)));
    }

    public static void Te(String str) {
        Td("lateinit property " + str + " has not been initialized");
    }

    public static void l(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) R(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void m(Object obj, String str) {
        if (obj == null) {
            Tf(str);
        }
    }

    private static void Tf(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) R(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean l(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void dUi() {
        Tg("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Tg(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void bM(int i, String str) {
        dUi();
    }

    private static <T extends Throwable> T R(T t) {
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
