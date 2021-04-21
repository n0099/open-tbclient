package d.h.c.a;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class k extends f {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
