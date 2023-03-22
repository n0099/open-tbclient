package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public final class PropertiesConventionUtilKt {
    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name name) {
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        if (JvmAbi.isGetterName(asString)) {
            return CollectionsKt__CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
        }
        if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        }
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
    }

    public static final Name propertyNameByGetMethodName(Name name) {
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(name, "get", false, null, 12, null);
        if (propertyNameFromAccessorMethodName$default == null) {
            return propertyNameFromAccessorMethodName$default(name, "is", false, null, 8, null);
        }
        return propertyNameFromAccessorMethodName$default;
    }

    public static final List<Name> propertyNamesBySetMethodName(Name name) {
        return CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(name, false), propertyNameBySetMethodName(name, true)});
    }

    public static final Name propertyNameBySetMethodName(Name name, boolean z) {
        String str;
        if (z) {
            str = "is";
        } else {
            str = null;
        }
        return propertyNameFromAccessorMethodName$default(name, "set", false, str, 4, null);
    }

    public static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z, String str2) {
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        Intrinsics.checkExpressionValueIsNotNull(identifier, "methodName.identifier");
        if (!StringsKt__StringsJVMKt.startsWith$default(identifier, str, false, 2, null) || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && 'z' >= charAt) {
            return null;
        }
        if (str2 != null) {
            if (_Assertions.ENABLED && !z) {
                throw new AssertionError("Assertion failed");
            }
            return Name.identifier(str2 + StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str));
        } else if (!z) {
            return name;
        } else {
            String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt__StringsKt.removePrefix(identifier, (CharSequence) str), true);
            if (!Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                return null;
            }
            return Name.identifier(decapitalizeSmartForCompiler);
        }
    }

    public static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z, str2);
    }
}
