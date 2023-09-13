package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix;
import kotlin.reflect.jvm.internal.impl.utils.NumbersKt;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt___StringsKt;
/* loaded from: classes2.dex */
public final class UtilsKt {
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ae, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b1 -> B:41:0x00b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final JavaDefaultValue lexicalCastFrom(KotlinType kotlinType, String str) {
        Object obj;
        ClassifierDescriptor mo2105getDeclarationDescriptor = kotlinType.getConstructor().mo2105getDeclarationDescriptor();
        if (mo2105getDeclarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) mo2105getDeclarationDescriptor;
            if (classDescriptor.getKind() == ClassKind.ENUM_CLASS) {
                MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
                Name identifier = Name.identifier(str);
                Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(value)");
                ClassifierDescriptor mo2107getContributedClassifier = unsubstitutedInnerClassesScope.mo2107getContributedClassifier(identifier, NoLookupLocation.FROM_BACKEND);
                if (!(mo2107getContributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                ClassDescriptor classDescriptor2 = (ClassDescriptor) mo2107getContributedClassifier;
                if (classDescriptor2.getKind() != ClassKind.ENUM_ENTRY) {
                    return null;
                }
                return new EnumEntry(classDescriptor2);
            }
        }
        KotlinType makeNotNullable = TypeUtilsKt.makeNotNullable(kotlinType);
        NumberWithRadix extractRadix = NumbersKt.extractRadix(str);
        String component1 = extractRadix.component1();
        int component2 = extractRadix.component2();
        try {
            if (KotlinBuiltIns.isBoolean(makeNotNullable)) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str));
            } else if (KotlinBuiltIns.isChar(makeNotNullable)) {
                obj = StringsKt___StringsKt.singleOrNull(str);
            } else if (KotlinBuiltIns.isByte(makeNotNullable)) {
                obj = StringsKt__StringNumberConversionsKt.toByteOrNull(component1, component2);
            } else if (KotlinBuiltIns.isShort(makeNotNullable)) {
                obj = StringsKt__StringNumberConversionsKt.toShortOrNull(component1, component2);
            } else if (KotlinBuiltIns.isInt(makeNotNullable)) {
                obj = StringsKt__StringNumberConversionsKt.toIntOrNull(component1, component2);
            } else if (KotlinBuiltIns.isLong(makeNotNullable)) {
                obj = StringsKt__StringNumberConversionsKt.toLongOrNull(component1, component2);
            } else if (KotlinBuiltIns.isFloat(makeNotNullable)) {
                obj = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
            } else {
                obj = KotlinBuiltIns.isDouble(makeNotNullable) ? StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str) : str;
            }
        } catch (IllegalArgumentException unused) {
        }
        if (obj != null) {
            return null;
        }
        return new Constant(obj);
        obj = null;
        if (obj != null) {
        }
    }
}
