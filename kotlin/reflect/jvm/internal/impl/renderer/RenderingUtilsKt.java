package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes9.dex */
public final class RenderingUtilsKt {
    public static final String render(FqNameUnsafe fqNameUnsafe) {
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(pathSegments, "pathSegments()");
        return renderFqName(pathSegments);
    }

    public static final String renderFqName(List<Name> list) {
        StringBuilder sb = new StringBuilder();
        for (Name name : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String render(Name name) {
        if (shouldBeEscaped(name)) {
            StringBuilder sb = new StringBuilder();
            String asString = name.asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "asString()");
            sb.append(String.valueOf('`') + asString);
            sb.append('`');
            return sb.toString();
        }
        String asString2 = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "asString()");
        return asString2;
    }

    public static final boolean shouldBeEscaped(Name name) {
        boolean z;
        boolean z2;
        if (name.isSpecial()) {
            return false;
        }
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "asString()");
        if (!KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            int i = 0;
            while (true) {
                if (i < asString.length()) {
                    char charAt = asString.charAt(i);
                    if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }
}
