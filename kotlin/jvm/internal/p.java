package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes14.dex */
public class p {
    private p() {
    }

    public static void eLc() {
        throw ((KotlinNullPointerException) S(new KotlinNullPointerException()));
    }

    public static void acq(String str) {
        throw ((UninitializedPropertyAccessException) S(new UninitializedPropertyAccessException(str)));
    }

    public static void acr(String str) {
        acq("lateinit property " + str + " has not been initialized");
    }

    public static void o(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) S(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void p(Object obj, String str) {
        if (obj == null) {
            acs(str);
        }
    }

    private static void acs(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) S(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static boolean l(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void eLd() {
        act("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void act(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void cl(int i, String str) {
        eLd();
    }

    private static <T extends Throwable> T S(T t) {
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
