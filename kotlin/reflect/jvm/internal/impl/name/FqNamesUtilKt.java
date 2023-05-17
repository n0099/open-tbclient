package kotlin.reflect.jvm.internal.impl.name;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes10.dex */
public final class FqNamesUtilKt {

    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.BEGINNING.ordinal()] = 1;
            $EnumSwitchMapping$0[State.AFTER_DOT.ordinal()] = 2;
            $EnumSwitchMapping$0[State.MIDDLE.ordinal()] = 3;
        }
    }

    public static final boolean isSubpackageOf(String str, String str2) {
        if (!StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null) || str.charAt(str2.length()) != '.') {
            return false;
        }
        return true;
    }

    public static final boolean isSubpackageOf(FqName fqName, FqName fqName2) {
        if (Intrinsics.areEqual(fqName, fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "this.asString()");
        String asString2 = fqName2.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "packageName.asString()");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isValidJavaFqName(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    continue;
                } else if (charAt == '.') {
                    state = State.AFTER_DOT;
                } else if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            } else {
                state = State.MIDDLE;
            }
        }
        if (state == State.AFTER_DOT) {
            return false;
        }
        return true;
    }

    public static final FqName tail(FqName fqName, FqName fqName2) {
        if (isSubpackageOf(fqName, fqName2) && !fqName2.isRoot()) {
            if (Intrinsics.areEqual(fqName, fqName2)) {
                FqName fqName3 = FqName.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(fqName3, "FqName.ROOT");
                return fqName3;
            }
            String asString = fqName.asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "asString()");
            int length = fqName2.asString().length() + 1;
            if (asString != null) {
                String substring = asString.substring(length);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return new FqName(substring);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        return fqName;
    }
}
