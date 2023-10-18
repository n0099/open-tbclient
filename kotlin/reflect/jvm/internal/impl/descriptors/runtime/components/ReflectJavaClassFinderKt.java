package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;
/* loaded from: classes10.dex */
public final class ReflectJavaClassFinderKt {
    public static final Class<?> tryLoadClass(ClassLoader classLoader, String str) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
