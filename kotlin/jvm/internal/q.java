package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes7.dex */
public class q {
    private q() {
    }

    public static String I(String str, Object obj) {
        return str + obj;
    }

    public static void dKw() {
        throw ((KotlinNullPointerException) O(new KotlinNullPointerException()));
    }

    public static void Sg(String str) {
        throw ((UninitializedPropertyAccessException) O(new UninitializedPropertyAccessException(str)));
    }

    public static void Sh(String str) {
        Sg("lateinit property " + str + " has not been initialized");
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) O(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            Si(str);
        }
    }

    private static void Si(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) O(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean h(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void dKx() {
        Sj("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Sj(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void bk(int i, String str) {
        dKx();
    }

    private static <T extends Throwable> T O(T t) {
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
