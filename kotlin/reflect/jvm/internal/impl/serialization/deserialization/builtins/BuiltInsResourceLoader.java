package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
/* loaded from: classes9.dex */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String str) {
        InputStream resourceAsStream;
        ClassLoader classLoader = BuiltInsResourceLoader.class.getClassLoader();
        if (classLoader == null || (resourceAsStream = classLoader.getResourceAsStream(str)) == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        return resourceAsStream;
    }
}
