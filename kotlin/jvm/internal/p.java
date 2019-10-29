package kotlin.jvm.internal;

import com.baidu.android.imsdk.internal.DefaultConfig;
import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* loaded from: classes2.dex */
public class p {
    private p() {
    }

    public static void cMY() {
        throw ((KotlinNullPointerException) D(new KotlinNullPointerException()));
    }

    public static void GY(String str) {
        throw ((UninitializedPropertyAccessException) D(new UninitializedPropertyAccessException(str)));
    }

    public static void GZ(String str) {
        GY("lateinit property " + str + " has not been initialized");
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) D(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            Ha(str);
        }
    }

    private static void Ha(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) D(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + DefaultConfig.TOKEN_SEPARATOR + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean f(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void cMZ() {
        Hb("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Hb(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void aP(int i, String str) {
        cMZ();
    }

    private static <T extends Throwable> T D(T t) {
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
