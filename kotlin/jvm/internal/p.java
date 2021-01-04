package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes5.dex */
public class p {
    private p() {
    }

    public static void eMi() {
        throw ((KotlinNullPointerException) T(new KotlinNullPointerException()));
    }

    public static void ack(String str) {
        throw ((UninitializedPropertyAccessException) T(new UninitializedPropertyAccessException(str)));
    }

    public static void acl(String str) {
        ack("lateinit property " + str + " has not been initialized");
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) T(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void o(Object obj, String str) {
        if (obj == null) {
            acm(str);
        }
    }

    private static void acm(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) T(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean l(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void eMj() {
        acn("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void acn(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void ce(int i, String str) {
        eMj();
    }

    private static <T extends Throwable> T T(T t) {
        return (T) d(t, p.class.getName());
    }

    static <T extends Throwable> T d(T t, String str) {
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
