package kotlin.reflect.jvm.internal;
/* loaded from: classes10.dex */
public class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
