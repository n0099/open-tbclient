package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes2.dex */
public class p {
    private p() {
    }

    public static void cCr() {
        throw ((KotlinNullPointerException) F(new KotlinNullPointerException()));
    }

    public static void FW(String str) {
        throw ((UninitializedPropertyAccessException) F(new UninitializedPropertyAccessException(str)));
    }

    public static void FX(String str) {
        FW("lateinit property " + str + " has not been initialized");
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) F(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void k(Object obj, String str) {
        if (obj == null) {
            FY(str);
        }
    }

    private static void FY(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) F(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean h(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void cCs() {
        FZ("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void FZ(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void aK(int i, String str) {
        cCs();
    }

    private static <T extends Throwable> T F(T t) {
        return (T) e(t, p.class.getName());
    }

    static <T extends Throwable> T e(T t, String str) {
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
