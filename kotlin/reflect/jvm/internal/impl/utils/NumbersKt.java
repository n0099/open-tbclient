package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes9.dex */
public final class NumbersKt {
    public static final NumberWithRadix extractRadix(String str) {
        if (!StringsKt__StringsJVMKt.startsWith$default(str, "0x", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(str, "0X", false, 2, null)) {
            if (!StringsKt__StringsJVMKt.startsWith$default(str, "0b", false, 2, null) && !StringsKt__StringsJVMKt.startsWith$default(str, "0B", false, 2, null)) {
                return new NumberWithRadix(str, 10);
            }
            String substring = str.substring(2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return new NumberWithRadix(substring, 2);
        }
        String substring2 = str.substring(2);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        return new NumberWithRadix(substring2, 16);
    }
}
