package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
/* loaded from: classes10.dex */
public final class NameUtils {
    public static final NameUtils INSTANCE = new NameUtils();
    public static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");

    @JvmStatic
    public static final String sanitizeAsJavaIdentifier(String str) {
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(str, "_");
    }
}
