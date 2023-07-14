package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes2.dex */
public final class CapitalizeDecapitalizeKt {
    public static final String capitalizeAsciiOnly(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && 'z' >= charAt) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(upperCase) + substring;
        }
        return str;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && 'Z' >= charAt) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(lowerCase) + substring;
        }
        return str;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z) {
        boolean z2;
        Integer num;
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && isUpperCaseCharAt(str, 0, z)) {
            if (str.length() != 1 && isUpperCaseCharAt(str, 1, z)) {
                Iterator<Integer> it = StringsKt__StringsKt.getIndices(str).iterator();
                while (true) {
                    if (it.hasNext()) {
                        num = it.next();
                        if (!isUpperCaseCharAt(str, num.intValue(), z)) {
                            break;
                        }
                    } else {
                        num = null;
                        break;
                    }
                }
                Integer num2 = num;
                if (num2 != null) {
                    int intValue = num2.intValue() - 1;
                    StringBuilder sb = new StringBuilder();
                    String substring = str.substring(0, intValue);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(toLowerCase(substring, z));
                    String substring2 = str.substring(intValue);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    sb.append(substring2);
                    return sb.toString();
                }
                return toLowerCase(str, z);
            } else if (z) {
                return decapitalizeAsciiOnly(str);
            } else {
                return StringsKt__StringsJVMKt.decapitalize(str);
            }
        }
        return str;
    }

    public static final boolean isUpperCaseCharAt(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            if ('A' <= charAt && 'Z' >= charAt) {
                return true;
            }
            return false;
        }
        return Character.isUpperCase(charAt);
    }

    public static final String toLowerCase(String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && 'Z' >= charAt) {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "builder.toString()");
        return sb2;
    }
}
